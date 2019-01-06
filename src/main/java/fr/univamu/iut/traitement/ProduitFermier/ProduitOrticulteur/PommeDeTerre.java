package fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur;

import java.time.LocalDate;
import java.util.List;

public class PommeDeTerre extends ProduitOrticulteur {

    public PommeDeTerre(){}

    public PommeDeTerre(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public PommeDeTerre(List<String> labels, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = generateDatePeremption();
        this.poids = poids;
        this.prix = prix;
    }

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
    @Override
    protected LocalDate generateDatePeremption() {
        return LocalDate.now().plusDays(30);
    }
}
