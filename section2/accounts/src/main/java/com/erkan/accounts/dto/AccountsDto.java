package com.erkan.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(name = "Accounts", description = "Schema to hold Account information")
@Data
public class AccountsDto {
    @Schema(description = "Bank account number", example = "3458764321")
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "^(\\+90|90|0)?5\\d{9}$", message = "Account number must be valid")
    private Long accountNumber;

    @Schema(description = "Type of the account (Savings/Current)", example = "Savings")
    @NotEmpty(message = "Account type cant be null or empty")
    private String accountType;

    @Schema(description = "Physical address of the bank branch", example = "123 Bağdat Caddesi, Kadıköy/İstanbul")
    @NotEmpty(message = "Branch Address cant be null or empty")
    private String branchAddress;

}
