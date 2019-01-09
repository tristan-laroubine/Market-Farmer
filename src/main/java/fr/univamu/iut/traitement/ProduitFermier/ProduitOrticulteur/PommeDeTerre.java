package fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur;

import java.time.LocalDate;
import java.util.List;

public class PommeDeTerre extends ProduitOrticulteur {

    /**
     * Constructeur vide
     */
    public PommeDeTerre(){}

    /**
     * Constructeur avec date de peremption
     * @param datePeremption
     */
    public PommeDeTerre(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    /**
     * Constructeur avec des labels, un poids et un prix
     * @param labels
     * @param poids
     * @param prix
     */
    public PommeDeTerre(List<String> labels, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * Constructeur avec un poids et un prix
     * @param poids
     * @param prix
     */
    public PommeDeTerre(Integer poids, Double prix) {
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
        return "PommeDeTerre";
    }

    /**
     * Genere une date de peremption, date d'aujourd'hui + 30 jours
     * @return LocalDate
     */
    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(30);
    }
}
