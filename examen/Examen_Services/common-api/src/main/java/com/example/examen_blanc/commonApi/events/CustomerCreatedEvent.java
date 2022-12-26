package com.example.examen_blanc.commonApi.events;

public class CustomerCreatedEvent extends BaseEvent<String> {
    private String name;
    private String address;
    private String email;
    private String phone;

    public CustomerCreatedEvent(String id, String name, String address, String email, String phone) {
        super(id);
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
