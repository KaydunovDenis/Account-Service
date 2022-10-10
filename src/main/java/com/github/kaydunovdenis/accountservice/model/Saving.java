package com.github.kaydunovdenis.accountservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Saving extends Transaction {
    private boolean replenish;
    private boolean capitalisation;

    //todo add percent

    public Saving(String title, BigDecimal amount, String currency, LocalDateTime timeTransaction) {
        super(title, amount, currency, timeTransaction);
    }

    public Saving(String title,
                  BigDecimal amount,
                  String currency,
                  LocalDateTime timeTransaction,
                  boolean replenish,
                  boolean capitalisation) {
        super(title, amount, currency, timeTransaction);
        this.replenish = replenish;
        this.capitalisation = capitalisation;
    }
}
