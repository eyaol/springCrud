package com.estudos.datatransferobject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(@NotBlank String username, @Email String email, @NotBlank String password) {
}
