package fr.univamu.iut.ProduitFermier.ProduitApiculteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Miel extends ProduitApiculteur {


    public Miel(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Miel(List<String> labels, LocalDate datePeremption, int poids, int prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Miel(LocalDate datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }



    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }



}
