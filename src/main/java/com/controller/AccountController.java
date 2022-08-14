package com.controller;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getOpenAccounts(@PathVariable long id) {
        return accountService.findByAccountID(id);
    }

    @GetMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getOpenAccounts() {
        return accountService.findAll();
    }

    @GetMapping(path = "/createAccount/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@PathVariable String name) {
        return accountService.createAccount(name);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello User";
    }
}
