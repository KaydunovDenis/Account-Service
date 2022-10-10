package com.github.kaydunovdenis.accountservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Transaction {
    private String title;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime timeTransaction;

    public Transaction() {
    }

    public Transaction(String title, BigDecimal amount, String currency, LocalDateTime timeTransaction) {
        this.title = title;
        this.amount = amount;
        this.currency = currency;
        this.timeTransaction = timeTransaction;
    }
}
