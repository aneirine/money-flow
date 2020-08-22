package com.aneirine.jarservice.api.jars.domain;

import com.aneirine.jarservice.entities.Jar;
import com.aneirine.jarservice.entities.enums.JarStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JarResponse {

    private long id;
    private String aim;
    private Date startDate;
    private Date endDate;
    private JarStatus status;
    private String description;
    private double sumGoal;
    private double sumCurrent;

    public JarResponse(Jar jar){
        this.aim = jar.getAim();
        this.description = jar.getDescription();
        this.endDate = jar.getEndDate();
        this.startDate = jar.getStartDate();
        this.id = jar.getId();
        this.status = jar.getStatus();
        this.sumCurrent = jar.getSumCurrent();
        this.sumGoal = jar.getSumGoal();
    }



}
