package com.github.kaydunovdenis.accountservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expanse extends Transaction {
    public Expanse(String title, BigDecimal amount, String currency, LocalDateTime timeTransaction) {
        super(title, amount, currency, timeTransaction);
    }
}
