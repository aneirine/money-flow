package com.aneirine.jarservice.entities.enums;

public enum JarStatus {

    ACTIVE, CLOSED;


    public static JarStatus getJarStatusByOrdinal(int ordinal){
        for(JarStatus temp : JarStatus.values()){
            if(temp.ordinal() == ordinal){
                return temp;
            }
        }
        throw
    }
}
