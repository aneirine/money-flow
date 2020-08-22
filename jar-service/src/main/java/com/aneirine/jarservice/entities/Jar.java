package com.aneirine.jarservice.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jars")
public class Jar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String aim;
    private Date startDate;
    private Date endDate;

}
