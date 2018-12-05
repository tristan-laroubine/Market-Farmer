package fr.univamu.iut.ProduitFermier.ProduitViande;

import fr.univamu.iut.Producteur.Producteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vache extends ProduitViande {


    public Vache(List<String> labels) {

    }
    public Vache(){

    }
    public Vache(String string){
        System.out.println("Vache crée avec une string => " + string);
    }

    public Vache(List<String> labels, Date datePeremption, Integer poids, Producteur producteur) {
        this.labels = labels;

        this.poids = poids;

        this.proprietaire = producteur;
    }

    public Vache(Integer poids) {

        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Vache";
    }
}
