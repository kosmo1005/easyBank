package com.cool_company.easy_bank.dto;

import jakarta.validation.constraints.NotNull;

public record ErrorResponseDto(
        @NotNull(message = "errorMessage must not be null")
        String errorMessage
) {
}
