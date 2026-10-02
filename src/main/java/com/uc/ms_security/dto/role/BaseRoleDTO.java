package com.uc.ms_security.dto.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRoleDTO {

    @NotBlank(
            message = "El nombre del rol es obligatorio"
    )
    @Size(
            max = 50,
            message = "El nombre del rol debe tener máximo 50 caracteres"
    )
    private String name;

    @Size(
            max = 255,
            message = "La descripción debe tener máximo 255 caracteres"
    )
    private String description;
}
