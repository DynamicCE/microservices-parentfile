package com.erkan.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "ErrorResponse", description = "Schema to hold API error response information")
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API path information", example = "/api/accounts/fetch")
    private String apiPath;

    @Schema(description = "Error status code", example = "NOT_FOUND")
    private HttpStatus errorCode;

    @Schema(description = "Detailed error message", example = "Customer not found with given mobile number")
    private String errorMessage;

    @Schema(description = "Timestamp when the error occurred", example = "2024-03-15T10:30:45")
    private LocalDateTime errorTime;
}
