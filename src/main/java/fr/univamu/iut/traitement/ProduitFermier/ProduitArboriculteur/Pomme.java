package fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur;

import java.time.LocalDate;
import java.util.List;

public class Pomme extends ProduitArboriculteur {

    public Pomme(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Pomme(List<String> labels, LocalDate datePeremption, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Pomme(LocalDate datePeremption, Integer poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Pomme";
    }
}
