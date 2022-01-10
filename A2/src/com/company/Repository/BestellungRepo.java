package com.company.Repository;

import com.company.Model.Bestellungen;

import java.util.List;

public class BestellungRepo {

    private List<Bestellungen> Bestellungen;

    public BestellungRepo(List<Bestellungen> bestellungen) {
        this.Bestellungen = bestellungen;
    }

    public List<Bestellungen> getBestellungen() {
        return Bestellungen;
    }

    public void insertBestellung(Bestellungen bestellung){
        if(Bestellungen.contains(bestellung)){
            System.out.println("Order already exist");
        }
        else{
            Bestellungen.add(bestellung);
        }
    }

    public void updateBestellung(Bestellungen bestellung){
        if (Bestellungen.contains(bestellung)) {
            int position = Bestellungen.indexOf(bestellung);
            Bestellungen.set(position, bestellung);
        }
        else{
            Bestellungen.add(bestellung);
        }
    }

    public void deleteBestellung(Bestellungen bestellung){
        if (Bestellungen.contains(bestellung)) {
            Bestellungen.remove(bestellung);
        }
        else{
            System.out.println("Order does not exist");
        }
    }
}
