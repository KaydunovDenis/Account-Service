package com.github.kaydunovdenis.accountservice;

import com.github.kaydunovdenis.accountservice.model.Account;
import com.github.kaydunovdenis.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class AccountServiceApplication implements CommandLineRunner {

    @Autowired
    private AccountRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Account("Alice", "Young girls from Brasilia",
                LocalDate.of(1990, 12,20)));
        repository.save(new Account("Bob", "Old man from Germany",
                LocalDate.of(2022, 3,21)));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Account account : repository.findAll()) {
            System.out.println(account);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Alice"));

        System.out.println("Customers found with findByDateLastSeen('2022, 3,21'):");
        System.out.println("--------------------------------");
        for (Account account : repository.findByDateLastSeen(new Date(2022, 3,21))) {
            System.out.println(account);
        }
    }
}
