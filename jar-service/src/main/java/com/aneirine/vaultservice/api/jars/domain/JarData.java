package com.aneirine.vaultservice.api.jars.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JarData {

    private String name;
    private long endDate;
    private double goalSum;
    private String description;
}
