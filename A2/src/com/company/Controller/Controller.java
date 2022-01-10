package com.company.Controller;

import com.company.Model.Bestellungen;
import com.company.Model.Produkte;
import com.company.Repository.BestellungRepo;
import com.company.Repository.ProduktRepo;

import java.util.List;

public class Controller {

    private ProduktRepo ProdutListe;
    private BestellungRepo BestllungListe;

    public Controller(ProduktRepo produtListe, BestellungRepo bestllungListe) {
        ProdutListe = produtListe;
        BestllungListe = bestllungListe;
    }

    public ProduktRepo getProdutListe() {
        return ProdutListe;
    }

    public BestellungRepo getBestllungListe() {
        return BestllungListe;
    }

}
