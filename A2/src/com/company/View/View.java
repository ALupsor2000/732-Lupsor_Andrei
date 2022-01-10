package com.company.View;

import com.company.Controller.Controller;
import com.company.Model.Bestellungen;
import com.company.Model.Produkte;

public class View {

    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void insertProd(Produkte produkt){
        controller.getProdutListe().insertProdukt(produkt);
    }
    public void updateProd(Produkte produkt){
        controller.getProdutListe().updateProdukt(produkt);
    }

    public void deleteProd(Produkte produkt){
        controller.getProdutListe().deleteProdukt(produkt);
    }

    public void insertOrd(Bestellungen order){
        controller.getBestllungListe().insertBestellung(order);
    }
    public void updateOrd(Bestellungen order){
        controller.getBestllungListe().updateBestellung(order);
    }

    public void deleteOrd(Bestellungen order){
        controller.getBestllungListe().deleteBestellung(order);
    }

    public void printProducts() {
        for(Produkte p : controller.getProdutListe().getProdukte())
            System.out.println(p);
    }

    public void printOrders() {
        for (Bestellungen b : controller.getBestllungListe().getBestellungen()) {
            System.out.println(b);
        }
    }
}