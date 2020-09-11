package com.aneirine.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @Column(unique = true)
    private String email;

    @ElementCollection
    private List<Long> transactionIdList;
    @ElementCollection
    private List<Long> jarIdList;
    @ElementCollection
    private List<Long> vaultIdList;

    public void addTransaction(long transactionId) {
        this.transactionIdList.add(transactionId);
    }

    public void removeTransaction(long transactionId) {
        this.transactionIdList.remove(transactionId);
    }

    public void addJar(long jarId) {
        this.jarIdList.add(jarId);
    }

    public void removeJar(long jarId) {
        this.jarIdList.remove(jarId);
    }

    public void addVault(long vaultId) {
        this.vaultIdList.add(vaultId);
    }

    public void removeVault(long vaultId) {
        this.vaultIdList.remove(vaultId);
    }


}
