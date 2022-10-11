package com.github.kaydunovdenis.accountservice.repository;

import com.github.kaydunovdenis.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByName(String name);
    List<Account> findByDateLastSeen(LocalDateTime lastDate);
}
