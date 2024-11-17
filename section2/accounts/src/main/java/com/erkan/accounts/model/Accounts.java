package com.erkan.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts extends BaseEntity {
    private Long customerId;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
