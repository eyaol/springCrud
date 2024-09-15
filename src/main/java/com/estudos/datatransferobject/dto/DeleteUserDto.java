package com.estudos.datatransferobject.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record DeleteUserDto(@NotEmpty List<String> ids) {
}
