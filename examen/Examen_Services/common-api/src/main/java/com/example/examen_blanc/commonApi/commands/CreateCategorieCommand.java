package com.example.examen_blanc.commonApi.commands;

public class CreateCategorieCommand extends BaseCommand<String>{
    private String name;
    private String desc;

    public CreateCategorieCommand(String id, String name, String desc) {
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
