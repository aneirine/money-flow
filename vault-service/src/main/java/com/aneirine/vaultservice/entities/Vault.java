package com.aneirine.vaultservice.entities;

import com.aneirine.vaultservice.entities.enums.VaultType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaults")
public class Vault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double sum;
    private String description;
    private VaultType type;

}
