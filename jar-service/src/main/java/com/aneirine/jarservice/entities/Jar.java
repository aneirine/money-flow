package com.aneirine.jarservice.entities;


import com.aneirine.jarservice.entities.enums.JarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jars")
public class Jar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String aim;
    private Date startDate;
    private Date endDate;
    private JarStatus status;
    private String description;
    private double sumGoal;
    private double sumCurrent;


}
