package com.erkan.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Accounts", description = "Schema to hold Account information")
public class AccountsDto {
    @Schema(description = "Bank account number", example = "3458764321")
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(description = "Type of the account (Savings/Current)", example = "Savings")
    @NotEmpty(message = "Account type cant be null or empty")
    private String accountType;

    @Schema(description = "Physical address of the bank branch",
            example = "123 Bağdat Caddesi, Kadıköy/İstanbul")
    @NotEmpty(message = "Branch Address cant be null or empty")
    private String branchAddress;

}
