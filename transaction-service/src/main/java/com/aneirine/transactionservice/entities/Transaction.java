package com.aneirine.transactionservice.entities;

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
    private TransactionType transactionType;

    @ManyToOne
    private TransactionCategory transactionCategory;


    public Transaction(String name, double sum, TransactionType transactionType, TransactionCategory transactionCategory) {
        this.name = name;
        this.sum = sum;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
    }
}
