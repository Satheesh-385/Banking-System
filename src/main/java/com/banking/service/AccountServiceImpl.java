package com.banking.service;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;

import jakarta.persistence.AssociationOverride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {

        // ❌ Same account check
        if (fromAccount.equals(toAccount)) {
            throw new RuntimeException("Cannot transfer to same account");
        }

        // ✅ Fetch sender
        Account sender = accountRepository.findByAccountNumber(fromAccount)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        // ✅ Fetch receiver
        Account receiver = accountRepository.findByAccountNumber(toAccount)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        // ❌ Balance check
        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // ✅ Transfer logic
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        // ✅ Save transaction
        Transaction txn = new Transaction();
        txn.setFromAccount(fromAccount);
        txn.setToAccount(toAccount);
        txn.setAmount(amount);
        txn.setType("TRANSFER");
        txn.setTimestamp(LocalDateTime.now());

        transactionRepository.save(txn);
    }

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(String accountNumber, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdraw(String accountNumber, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double checkBalance(String accountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactions(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}