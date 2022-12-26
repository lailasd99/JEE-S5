package com.example.examen_blanc.commonApi.commands;

public class UpdateOrderLigneCommand extends BaseCommand<String>{
    private int quantity;
    private double price;
    private double remise;

    public UpdateOrderLigneCommand(String id, int quantity, double price, double remise) {
        super(id);
        this.quantity = quantity;
        this.price = price;
        this.remise = remise;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getRemise() {
        return remise;
    }
}
