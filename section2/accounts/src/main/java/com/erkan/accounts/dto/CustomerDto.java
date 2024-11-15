package com.erkan.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Schema to hold Customer and Account information")
public class CustomerDto {

    @Schema(description = "Name of the customer", example = "Erkan Murat")
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The name should be between 5 and 30")
    private String name;

    @Schema(description = "Email address of the customer")
    @NotEmpty(message = "Email cannot be a null or empty")
    @Email(message = "E mail address should be a valid value")
    private String email;

    @Schema(description = "Mobile number of the customer")
    @Pattern(regexp = "^(\\+90|90|0)?5\\d{9}$", message = "Mobile number must be a valid Turkish phone number")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
