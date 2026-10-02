package com.uc.ms_security.dto.session;

import lombok.Value;

import java.util.Date;

@Value
public class SessionResponseDTO {
    Long id;
    String token;
    Date expiration;
    String code2FA;
}
