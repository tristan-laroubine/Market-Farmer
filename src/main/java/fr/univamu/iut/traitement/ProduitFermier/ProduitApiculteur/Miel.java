package fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur;

import java.time.LocalDate;
import java.util.List;

public class Miel extends ProduitApiculteur {


    public Miel(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Miel(List<String> labels, LocalDate datePeremption, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Miel(LocalDate datePeremption, Integer poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Miel";
    }
}
