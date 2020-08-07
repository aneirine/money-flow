package com.aneirine.moneyflow.entities;

import com.aneirine.moneyflow.entities.enums.TransactionType;
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

}
