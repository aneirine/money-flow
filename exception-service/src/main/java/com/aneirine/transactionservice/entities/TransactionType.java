package com.aneirine.transactionservice.entities;


import com.aneirine.transactionservice.exceptions.NotFoundException;

public enum TransactionType {
    DAY, WEEK, MONTH;


    public static TransactionType getTransactionTypeByOrdinal(int ordinal){
        for(TransactionType temp : TransactionType.values()){
            if(temp.ordinal() == ordinal) {
                return temp;
            }
        }
        throw new NotFoundException("TRANSACTIONAL_TYPE_NOT_FOUND");
    }
}
