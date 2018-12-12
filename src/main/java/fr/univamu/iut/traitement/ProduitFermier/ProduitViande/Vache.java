package fr.univamu.iut.traitement.ProduitFermier.ProduitViande;

import fr.univamu.iut.traitement.Producteur.Producteur;

import java.util.Date;
import java.util.List;

public class Vache extends ProduitViande {


    public Vache(){

    }

    public Vache(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.poids = poids;
        this.prix = prix;
    }

    public Vache(Integer poids, Double prix) {
        this.poids = poids;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vache";
    }
}
