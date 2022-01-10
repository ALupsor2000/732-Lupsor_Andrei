package com.company;

import com.company.Model.Bestellungen;
import com.company.Model.Produkte;
import com.company.Repository.BestellungRepo;
import com.company.Repository.ProduktRepo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Produkte> products = new ArrayList<>();
        ArrayList<Bestellungen> orders = new ArrayList<>();
        ProduktRepo prodRepo = new ProduktRepo(products);
        BestellungRepo orderRepo = new BestellungRepo(orders);

        Produkte p1 = new Produkte("Milka", 5.67);
        Produkte p2 = new Produkte("Oreo", 4.20);
        Produkte p3 = new Produkte("Coca Cola", 3.25);
        Produkte p4 = new Produkte("Paine alba", 6.30);
        Produkte p5 = new Produkte("Biscuiti", 4.89);

        ArrayList<Produkte> prodList1 = new ArrayList<>();
        ArrayList<Produkte> prodList2 = new ArrayList<>();

        prodList1.add(p1);
        prodList1.add(p2);
        prodList1.add(p3);
        prodList2.add(p4);
        prodList2.add(p5);

        Bestellungen b1 = new Bestellungen(1, "str.Republicii", prodList1 );
    }
}
