package boo.web.voting.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter

public class UserDeleteRequestDto {
    private String email;
    private String password;

}
