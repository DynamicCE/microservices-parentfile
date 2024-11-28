package com.erkan.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Loans", description = "Schema to hold Loan information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {

    private String loanNumber;
    private String loanType;
    private String mobileNumber;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}
