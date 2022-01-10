package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class Bestellungen {

    private int Bestellnr;
    private String Adresse;
    private ArrayList<Produkte> produkte;

    public Bestellungen(int bestellnr, String adresse, ArrayList<Produkte> produkte) {
        Bestellnr = bestellnr;
        Adresse = adresse;
        this.produkte = produkte;
    }

    public int getBestellnr() {
        return Bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        Bestellnr = bestellnr;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public ArrayList<Produkte> getProdukte() {
        return produkte;
    }

    public void setProdukte(ArrayList<Produkte> produkte) {
        this.produkte = produkte;
    }

    public String toString() {
        return "Bestellnr=" + Bestellnr +
                ", Adresse='" + Adresse + '\'' +
                ", produkte=" + produkte;
    }

    public double totalPrice(){
        double sum = 0;
        for(Produkte p : produkte){
            sum = sum + p.getPreis();
        }

        return sum;
    }
}
