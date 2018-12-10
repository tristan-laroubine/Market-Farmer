package fr.univamu.iut.traitement.ProduitFermier.ProduitViande;


import fr.univamu.iut.traitement.Producteur.Producteur;

import java.util.List;

public class Cochon extends ProduitViande {

    public Cochon(){

    }

    public Cochon(List<String> labels, Integer poids, Producteur producteur) {
        this.labels = labels;

        this.poids = poids;
        this.proprietaire = producteur;
    }

    public Cochon(Integer poids) {

        this.poids = poids;
    }

    public Cochon(Integer poids, Integer prix, Producteur producteur){
        this.poids = poids;
        this.proprietaire = producteur;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Cochon";
    }
}
