package ua.khylko98.player;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonInclude(ALWAYS)
public class PlayerRegistrationRequest {
    private String username;
    private String password;
}
