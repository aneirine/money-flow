package com.aneirine.moneyflow.entities;

import com.aneirine.moneyflow.entities.enums.JarStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "jars")
public class Jar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;
    private long startDate;
    private long endDate;
    private JarStatus status;
    private double currentSum;
    private double goalSum;
    private String description;

}
