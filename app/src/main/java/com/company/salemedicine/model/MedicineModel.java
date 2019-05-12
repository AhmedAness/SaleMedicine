package com.company.salemedicine.model;

public class MedicineModel {
    long id;
    String name;
    double price;
    int quantaty;

    public MedicineModel(long id, String name, double price, int quantaty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantaty = quantaty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantaty() {
        return quantaty;
    }

    public void setQuantaty(int quantaty) {
        this.quantaty = quantaty;
    }
}
