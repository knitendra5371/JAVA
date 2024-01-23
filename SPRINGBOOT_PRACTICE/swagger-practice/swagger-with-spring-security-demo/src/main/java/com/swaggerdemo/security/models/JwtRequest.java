package com.swaggerdemo.security.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtRequest {

    private String email;
    private String password;

}
