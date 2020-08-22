package com.aneirine.jarservice.entities.enums;

import com.aneirine.jarservice.exceptions.NotFoundException;

public enum JarStatus {

    ACTIVE, CLOSED;


    public static JarStatus getJarStatusByOrdinal(int ordinal) {
        for (JarStatus temp : JarStatus.values()) {
            if (temp.ordinal() == ordinal) {
                return temp;
            }
        }
        throw new NotFoundException("JAR_STATUS_NOT_FOUND");
    }
}
