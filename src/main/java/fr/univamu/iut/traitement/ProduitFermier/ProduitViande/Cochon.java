package fr.univamu.iut.traitement.ProduitFermier.ProduitViande;


import fr.univamu.iut.traitement.Producteur.Producteur;

import java.util.List;

public class Cochon extends ProduitViande {

    public Cochon(){

    }

    public Cochon(List<String> labels, Integer poids, Double prix) {
        this.labels = labels;
        this.prix = prix;
        this.poids = poids;

    }

    public Cochon(Integer poids, Double prix){
        this.poids = poids;

        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Cochon";
    }
}
