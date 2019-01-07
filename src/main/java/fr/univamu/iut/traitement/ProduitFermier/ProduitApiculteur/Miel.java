package fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur;

import java.time.LocalDate;
import java.util.List;

public class Miel extends ProduitApiculteur{


    public Miel(List<String> labels) {
        this.datePeremption = generateDatePeremption();
    }

    public Miel(List<String> labels, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    public Miel(Integer poids, Double prix) {
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * Force la conversion en String de la classe
     * @return le nom de la classe est les informations
     */
    @Override
    public String toString() {
        return "Miel";
    }

    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(64);
    }


}
