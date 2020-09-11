package com.aneirine.userservice.api.users.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class IdListData {

    private List<Long> list;

    public IdListData(List<Long> list) {
        this.list = new ArrayList<>(list);
    }
}
