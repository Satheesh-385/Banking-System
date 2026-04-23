package com.banking.service;

import com.banking.entity.Account;
import com.banking.entity.Transaction;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account deposit(String accountNumber, double amount);

    Account withdraw(String accountNumber, double amount);

    double checkBalance(String accountNumber);

    List<Account> getAllAccounts();

    // NEW FEATURES
    void transfer(String fromAcc, String toAcc, double amount);

    List<Transaction> getTransactions(String accountNumber);
}