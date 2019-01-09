package fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier;

import java.time.LocalDate;
import java.util.List;

public class Lait extends ProduitLaitier {

    /**
     * Constructeur avec datePeremption
     * @param datePeremption
     */
    public Lait(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    /**
     * Constructeur avec label, poids et prix
     * @param labels
     * @param poids
     * @param prix
     */
    public Lait(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * Constructeur poids et prix
     * @param poids
     * @param prix
     */
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

    /**
     * Genere une date de peremption, date d'aujourd'hui + 7 jours
     * @return
     */
    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(7);
    }
}
