package com.github.kaydunovdenis.accountservice.repository;

import com.github.kaydunovdenis.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

//    @Query("{name:'?0'}")
//    GroceryItem findItemByName(String name);
//
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<GroceryItem> findAll(String category);
//
//    public long count();
}
