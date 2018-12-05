package fr.univamu.iut.ProduitFermier.ProduitLaitier;

import java.time.LocalDate;
import java.util.List;

public class Lait extends ProduitLaitier {

    public Lait(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Lait(List<String> labels, LocalDate datePeremption, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Lait(LocalDate datePeremption, Integer poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Lait";
    }


}
