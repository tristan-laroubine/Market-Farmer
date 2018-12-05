package fr.univamu.iut.ProduitFermier.ProduitViande;


import fr.univamu.iut.Producteur.Producteur;

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





}
