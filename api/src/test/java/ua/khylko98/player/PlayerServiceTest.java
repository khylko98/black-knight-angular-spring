package ua.khylko98.player;

import com.sun.jdi.request.DuplicateRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.khylko98.exception.PlayerWithThisUsernameAlreadyCreatedException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerDAO playerDAO;
    @Mock
    private PasswordEncoder passwordEncoder;
    private PlayerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayerService(playerDAO, passwordEncoder);
    }

    @Test
    void addPlayer() {
        // Given
        String username = "username";

        when(playerDAO.existsPlayerWithUsername(username))
                .thenReturn(false);

        PlayerRegistrationRequest request = PlayerRegistrationRequest
                .builder()
                .username(username)
                .password("password")
                .build();

        String passwordHash = "¢5554ml;f;lsd";

        when(passwordEncoder.encode(request.getPassword()))
                .thenReturn(passwordHash);

        // When
        underTest.addPlayer(request);

        // Then
        ArgumentCaptor<Player> playerArgumentCaptor =
                ArgumentCaptor.forClass(Player.class);

        verify(playerDAO).insertPlayer(playerArgumentCaptor.capture());

        Player capturedPlayer = playerArgumentCaptor.getValue();

        assertThat(capturedPlayer.getId())
                .isNull();
        assertThat(capturedPlayer.getUsername())
                .isEqualTo(request.getUsername());
        assertThat(capturedPlayer.getPassword())
                .isEqualTo(passwordHash);
    }

    @Test
    void willThrowWhenUsernameExistsWhileAddingPlayer() {
        // Given
        String username = "username";

        when(playerDAO.existsPlayerWithUsername(username))
                .thenReturn(true);

        PlayerRegistrationRequest request = PlayerRegistrationRequest
                .builder()
                .username(username)
                .password("password")
                .build();

        // When
        assertThatThrownBy(() -> underTest.addPlayer(request))
                .isInstanceOf(
                        PlayerWithThisUsernameAlreadyCreatedException.class
                )
                .hasMessage("Player with this username already created");

        // Then
        verify(playerDAO, never()).insertPlayer(any());
    }

}
