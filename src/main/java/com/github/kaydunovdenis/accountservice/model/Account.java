package com.github.kaydunovdenis.accountservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("account")
public class Account {

    /**
     * @Id
     * private String id;
     *
     * If we don’t specify anything, MongoDB will generate an _id field while creating the document.
     */

    private String name;
    private String description;
    private Date dateLastSeen;
    private List<Income> incomes;
    private List<Expanse> expanses;
}

