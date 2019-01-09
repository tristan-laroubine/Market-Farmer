package fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur;

import java.time.LocalDate;
import java.util.List;

public class Miel extends ProduitApiculteur{


    /**
     * Constructeur
     * @param labels
     */
    public Miel(List<String> labels) {
        this.datePeremption = generateDatePeremption();
    }

    /**
     * Constructeur avec label, poids et prix
     * @param labels
     * @param poids
     * @param prix
     */
    public Miel(List<String> labels, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * COnstructeur avec poids et prix
     * @param poids
     * @param prix
     */
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

    /**
     * Genere une date de peremption de la date actuel plus 64 jours
     * @return
     */
    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(64);
    }


}
