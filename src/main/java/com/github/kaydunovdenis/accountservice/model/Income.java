package com.github.kaydunovdenis.accountservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Income extends Transaction {
    public Income(String title, BigDecimal amount, String currency, LocalDateTime timeTransaction) {
        super(title, amount, currency, timeTransaction);
    }
}
