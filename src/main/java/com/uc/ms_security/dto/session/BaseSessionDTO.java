package com.uc.ms_security.dto.session;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseSessionDTO {

    @NotBlank(
            message = "El token es obligatorio"
    )
    @Size(
            max = 255,
            message = "El token debe tener máximo 255 caracteres"
    )
    private String token;

    @NotNull(
            message = "La fecha de expiración es obligatoria"
    )
    private Date expiration;
}
