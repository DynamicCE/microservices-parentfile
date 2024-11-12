package com.erkan.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erkan.accounts.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
