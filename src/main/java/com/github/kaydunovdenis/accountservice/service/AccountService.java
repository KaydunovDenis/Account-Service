package com.github.kaydunovdenis.accountservice.service;

import com.github.kaydunovdenis.accountservice.exception.AccountMissingException;
import com.github.kaydunovdenis.accountservice.model.Account;
import com.github.kaydunovdenis.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account findById(String id) throws AccountMissingException {
        return repository.findById(id).orElseThrow(AccountMissingException::new);
    }

    public Account findByName(String name){
        return repository.findByName(name);
    }


    public Account saveOrUpdate(Account account) {
        //TODO добавить проверку уникальности по имени
        return repository.save(account);
    }
}
