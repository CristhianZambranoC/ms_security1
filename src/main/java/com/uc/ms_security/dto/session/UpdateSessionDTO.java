package com.uc.ms_security.dto.session;

import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSessionDTO
        extends BaseSessionDTO {

    @Size(
            max = 10,
            message = "El código 2FA debe tener máximo 10 caracteres"
    )
    private String code2FA;
}
