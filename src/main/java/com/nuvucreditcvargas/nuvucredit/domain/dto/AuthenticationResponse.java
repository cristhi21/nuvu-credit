package com.nuvucreditcvargas.nuvucredit.domain.dto;

public class AuthenticationResponse {
    //Se responde al Request con el jwt
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
