package com.service;

import com.model.Account;
import com.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private IAccountRepository accountRepository;

    public Account findByAccountID(Long ID) {
        return accountRepository.findById(ID).orElse(null);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account createAccount(String name) {
        Account account = new Account();
        account.setName(name);
        return accountRepository.saveAndFlush(account);
    }
}
