package com.example.examen_blanc.commonApi.events;

public class CategorieUpdatedEvent extends BaseEvent<String> {
    private String name;
    private String desc;

    public CategorieUpdatedEvent(String id, String name, String desc) {
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
