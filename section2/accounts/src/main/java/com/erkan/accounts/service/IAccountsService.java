package com.erkan.accounts.service;

import com.erkan.accounts.dto.CustomerDto;
import com.erkan.accounts.model.Accounts;
import com.erkan.accounts.model.Customer;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);

    Accounts createNewAccount(Customer customer);
}
