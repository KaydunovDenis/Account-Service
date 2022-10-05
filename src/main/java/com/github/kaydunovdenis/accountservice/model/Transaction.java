package com.github.kaydunovdenis.accountservice.model;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Transaction {
    private String title;
    private BigDecimal amount;
    private String currency;
    private Date timeTransaction;
}
