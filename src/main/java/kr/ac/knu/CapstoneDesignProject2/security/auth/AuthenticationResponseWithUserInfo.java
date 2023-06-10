package kr.ac.knu.CapstoneDesignProject2.security.auth;

import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseWithUserInfo {

    private String token;
    private UserEntity userEntity;

}
