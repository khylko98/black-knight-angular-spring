package ua.khylko98.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PlayerJPADataAccessServiceTest {

    @Mock
    private PlayerRepository userRepository;
    private PlayerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PlayerJPADataAccessService(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void insertPlayer() {
        // Given
        Player player = new Player(
                1L,
                "username",
                "password"
        );

        // When
        underTest.insertPlayer(player);

        // Then
        verify(userRepository).save(player);
    }

    @Test
    void existsPlayerWithUsername() {
        // Given
        String username = "username";

        // When
        underTest.existsPlayerWithUsername(username);

        // Then
        verify(userRepository).existsPlayerByUsername(username);
    }

    @Test
    void selectPlayerByUsername() {
        // Given
        String username = "username";

        // When
        underTest.selectPlayerByUsername(username);

        // Then
        verify(userRepository).findPlayerByUsername(username);
    }

}
