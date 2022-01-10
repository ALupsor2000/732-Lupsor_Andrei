package com.company.Repository;

import com.company.Model.Produkte;

import java.util.List;

public class ProduktRepo {

    private List<Produkte> Produkten;

    public ProduktRepo(List<Produkte> produkte) {
        Produkten = produkte;
    }

    public List<Produkte> getProdukte() {
        return Produkten;
    }

    public void insertProdukt(Produkte produkt){
        if(Produkten.contains(produkt)){
            System.out.println("Product already exist");
        }
        else{
            Produkten.add(produkt);
        }
    }

    public void updateProdukt(Produkte produkt){
        if (Produkten.contains(produkt)) {
            int position = Produkten.indexOf(produkt);
            Produkten.set(position, produkt);
        }
        else{
            Produkten.add(produkt);
        }
    }

    public void deleteProdukt(Produkte produkt){
        if (Produkten.contains(produkt)) {
            Produkten.remove(produkt);
        }
        else{
            System.out.println("Product does not exist");
        }
    }

}
