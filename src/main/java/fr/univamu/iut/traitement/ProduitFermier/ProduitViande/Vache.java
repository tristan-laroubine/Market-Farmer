package fr.univamu.iut.traitement.ProduitFermier.ProduitViande;

import fr.univamu.iut.traitement.Producteur.Producteur;

import java.util.Date;
import java.util.List;

public class Vache extends ProduitViande {


    /**
     * Constructeur vache vide
     */
    public Vache(){
    }

    /**
     * Constructeur vache avec label, poids et prix
     * @param labels
     * @param poids
     * @param prix
     */
    public Vache(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.poids = poids;
        this.prix = prix;
    }

    /**
     * Constructeur vache avec poids et prix
     * @param poids
     * @param prix
     */
    public Vache(Integer poids, Double prix) {
        this.poids = poids;
        this.prix = prix;
    }
    /**
     * Force la conversion en String de la classe
     * @return le nom de la classe est les informations
     */
    @Override
    public String toString() {
        return "Vache";
    }
}
