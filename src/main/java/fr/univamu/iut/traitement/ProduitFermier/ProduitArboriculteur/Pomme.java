package fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur;

import java.time.LocalDate;
import java.util.List;

public class Pomme extends ProduitArboriculteur{

    /**
     * Constructeur avec date de peremption
     * @param datePeremption
     */
    public Pomme(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    /**
     * Constructeur avec label, poids et prix
     * @param labels
     * @param poids
     * @param prix
     */
    public Pomme(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * Constructeur avec poids et prix
     * @param poids
     * @param prix
     */
    public Pomme(Integer poids, Double prix) {
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
        return "Pomme";
    }

    /**
     * Genere une date de peremption, date d'aujourd'hui + 64 jours
     * @return
     */
    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(64);
    }

}
