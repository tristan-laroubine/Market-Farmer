package fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier;

import java.time.LocalDate;
import java.util.List;

public class Lait extends ProduitLaitier {

    public Lait(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Lait(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    public Lait(Integer poids, Double prix) {
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
        return "Lait";
    }


    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(7);
    }
}
