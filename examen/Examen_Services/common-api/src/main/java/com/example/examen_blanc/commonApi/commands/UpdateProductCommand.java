package com.example.examen_blanc.commonApi.commands;

import com.example.examen_blanc.commonApi.enums.Etat;

public class UpdateProductCommand extends BaseCommand<String>{
    private String name;
    private double price;
    private int stock;
    private Etat state;

    public UpdateProductCommand(String id, String name, double price, int stock, Etat state) {
        super(id);
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Etat getState() {
        return state;
    }
}
