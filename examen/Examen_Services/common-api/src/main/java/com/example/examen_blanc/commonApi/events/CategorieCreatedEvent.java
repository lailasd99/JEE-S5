package com.example.examen_blanc.commonApi.events;

import com.example.examen_blanc.commonApi.enums.Etat;

public class CategorieCreatedEvent extends BaseEvent<String> {
    private String name;
    private String desc;

    public CategorieCreatedEvent(String id, String name, String desc) {
        super(id);
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}


