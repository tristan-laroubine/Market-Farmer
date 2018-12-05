package fr.univamu.iut.ProduitFermier.ProduitLaitier;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Lait extends ProduitLaitier {

    public Lait(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Lait(List<String> labels, LocalDate datePeremption, int poids, int prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Lait(LocalDate datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }
}
