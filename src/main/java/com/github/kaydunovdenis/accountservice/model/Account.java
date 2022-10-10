package com.github.kaydunovdenis.accountservice.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * MongoDB stores data in collections.
 * Spring Data MongoDB maps the Account class into a collection called account.
 * If you want to change the name of the collection, you can
 * use Spring Data MongoDB’s @Document annotation on the class
 * :  @Document("anotherName")
 */
public class Account {

    /**
     * @Id private String id;
     * <p>
     * If we don’t specify anything, MongoDB will generate an _id field while creating the document.
     */

    private String name;
    private String description;
    private LocalDate dateLastSeen;
    private List<Income> incomes;
    private List<Expanse> expanses;

    public Account() {
    }

    public Account(String name, String description, LocalDate dateLastSeen) {
        this.name = name;
        this.description = description;
        this.dateLastSeen = dateLastSeen;
    }

    public Account(String name, String description, LocalDate dateLastSeen, List<Income> incomes, List<Expanse> expanses) {
        this.name = name;
        this.description = description;
        this.dateLastSeen = dateLastSeen;
        this.incomes = incomes;
        this.expanses = expanses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateLastSeen() {
        return dateLastSeen;
    }

    public void setDateLastSeen(LocalDate dateLastSeen) {
        this.dateLastSeen = dateLastSeen;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Expanse> getExpanses() {
        return expanses;
    }

    public void setExpanses(List<Expanse> expanses) {
        this.expanses = expanses;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateLastSeen=" + dateLastSeen.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")) +
                ", incomes=" + incomes +
                ", expanses=" + expanses +
                '}';
    }
}

