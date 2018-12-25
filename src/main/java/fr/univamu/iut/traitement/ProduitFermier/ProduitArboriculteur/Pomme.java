package fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur;

import java.time.LocalDate;
import java.util.List;

public class Pomme extends ProduitArboriculteur {

    public Pomme(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Pomme(List<String> labels, LocalDate datePeremption, Integer poids, Double prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Pomme(LocalDate datePeremption, Integer poids, Double prix) {
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }
    /**
     * Force la conversion en String de la classe
     * @return le nom de la classe est les informations
     */
    @Override
    public String toString() {
        return "Pomme";
    }
}
