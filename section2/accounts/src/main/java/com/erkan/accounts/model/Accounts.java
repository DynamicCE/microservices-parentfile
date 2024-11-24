package com.erkan.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Accounts extends BaseEntity {
    private Long customerId;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
