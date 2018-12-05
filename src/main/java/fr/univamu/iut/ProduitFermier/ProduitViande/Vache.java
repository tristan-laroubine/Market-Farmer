package fr.univamu.iut.ProduitFermier.ProduitViande;

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

    public Vache(List<String> labels, Date datePeremption, int poids) {
        this.labels = labels;

        this.poids = poids;
    }

    public Vache(int poids) {

        this.poids = poids;
    }


}
