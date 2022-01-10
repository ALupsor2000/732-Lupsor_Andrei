package com.company.Model;

public class Produkte {

    private String Name;
    private double Preis;

    public Produkte(String name, double preis) {
        Name = name;
        Preis = preis;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPreis() {
        return Preis;
    }

    public void setPreis(int preis) {
        Preis = preis;
    }

    public String toString() {
        return "Name='" + Name + '\'' +
                ", Preis=" + Preis;
    }
}
