package com.aneirine.moneyflow.api.jars.domain;

import com.aneirine.moneyflow.entities.Jar;
import com.aneirine.moneyflow.entities.enums.JarStatus;

public class JarResponse {

    private long id;
    private String name;
    private long startDate;
    private long endDate;
    private JarStatus status;
    private double currentSum;
    private double goalSum;
    private String description;

    private double sumLeft;
    private double timeLeft;

    public JarResponse(Jar jar) {
        this.id = jar.getId();
        this.name = jar.getName();
        this.currentSum = jar.getCurrentSum();
        this.startDate = jar.getStartDate();
        this.endDate = jar.getEndDate();
        this.status = jar.getStatus();
        this.goalSum = jar.getGoalSum();
        this.description = jar.getDescription();
        this.sumLeft = jar.getGoalSum() - jar.getCurrentSum();
        this.timeLeft = jar.getEndDate() - System.currentTimeMillis();
    }
}
