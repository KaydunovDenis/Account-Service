package com.github.kaydunovdenis.accountservice.repository;

import com.github.kaydunovdenis.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    public Account findByName(String name);
    public List<Account> findByDateLastSeen(Date lastDate);

//    @Query("{name:'?0'}")
//    GroceryItem findItemByName(String name);
//
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<GroceryItem> findAll(String category);
//
//    public long count();
}
