package com.example.examen_blanc.commonApi.events;

public class OrderLigneUpdatedEvent extends BaseEvent<String> {
    private int quantity;
    private double price;
    private double remise;

    public OrderLigneUpdatedEvent(String id, int quantity, double price, double remise) {
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
