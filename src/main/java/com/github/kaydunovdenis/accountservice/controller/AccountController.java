package com.github.kaydunovdenis.accountservice.controller;

import com.github.kaydunovdenis.accountservice.exception.AccountMissingException;
import com.github.kaydunovdenis.accountservice.model.Account;
import com.github.kaydunovdenis.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) throws AccountMissingException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/current")
    public ResponseEntity<Account> getCurrent() throws AccountMissingException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(getIdCurrentAccount()));
    }

    @GetMapping("/demo")
    public ResponseEntity<Account> getDemo() throws AccountMissingException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById("demo"));
    }

    @PutMapping("/current")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(account));
    }

    @PostMapping()
    public ResponseEntity<Account> createAccount (@RequestBody Account account) {
       //todo если уже есть, и это не он, то бросить ошибку что имя занято

        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(account));
    }

    //Todo
    private String getIdCurrentAccount() {
        return null;
    }
}
