package com.github.kaydunovdenis.accountservice.service;

import com.github.kaydunovdenis.accountservice.AccountServiceApplication;
import com.github.kaydunovdenis.accountservice.exception.AccountMissingException;
import com.github.kaydunovdenis.accountservice.model.Account;
import com.github.kaydunovdenis.accountservice.model.Expanse;
import com.github.kaydunovdenis.accountservice.model.Income;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = AccountServiceApplication.class)
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void saveOrUpdate() {
        //Given
        Account account = createAccount();
        //When
        Account savedAccount = accountService.saveOrUpdate(account);
        //Then
        assertEquals(account, savedAccount);
    }

    @Test
    void findById() {
        //Given
        Account account = createAccount();
        account.setId("1");
        //TODO
        Throwable exception1 = assertThrows(AccountMissingException.class, () ->
                accountService.findById("1")
        );
        assertEquals("some message", exception1.getMessage());

        //when
        accountService.saveOrUpdate(account);
        Throwable exception2 = assertThrows(AccountMissingException.class, () -> {
                    Account actualAccount = accountService.findById("1");
                    assertEquals(account, actualAccount);
                }
        );
        assertNull(exception2);
    }

    private static Account createAccount() {
        Account account = new Account();
        account.setName("Nikolas");
        account.setDescription("Some description");
        account.setDateLastSeen(LocalDate.of(1990, 12, 20));

        List<Expanse> expanses = List.of(
                new Expanse("Bear", new BigDecimal("23.4"), "USD", LocalDateTime.of(2020, 12, 20, 2, 35, 0)),
                new Expanse("Milk", new BigDecimal("1.25"), "USD", LocalDateTime.of(2020, 12, 20, 14, 59, 1)),
                new Expanse("Traveling", new BigDecimal("100.35"), "EUR", LocalDateTime.of(2021, 1, 12, 1, 19, 21))
        );
        account.setExpanses(expanses);

        List<Income> incomes = List.of(
                new Income("Salary", new BigDecimal("2000"), "USD", LocalDateTime.of(2020, 12, 2, 2, 35, 5)),
                new Income("Salary", new BigDecimal("2000"), "USD", LocalDateTime.of(2020, 11, 1, 1, 21, 12)),
                new Income("Dividends", new BigDecimal("2000"), "USD", LocalDateTime.of(2020, 12, 2, 13, 35, 54))
        );
        account.setIncomes(incomes);
        return account;
    }

}