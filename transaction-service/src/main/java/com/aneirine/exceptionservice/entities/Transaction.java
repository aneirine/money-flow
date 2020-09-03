package com.aneirine.exceptionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double sum;
    private int transactionType;

    @ManyToOne
    private TransactionCategory transactionCategory;


    public Transaction(String name, double sum, int transactionType, TransactionCategory transactionCategory) {
        this.name = name;
        this.sum = sum;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
    }
}
