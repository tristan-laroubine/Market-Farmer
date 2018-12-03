package fr.univamu.iut.ProduitFermier.ProduitViande;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vache extends ProduitViande {
    List<String> labels = new ArrayList<>();

    int poids;

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

    public Vache(Date datePeremption, int poids) {

        this.poids = poids;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void addLabel(String label){
        this.labels.add(label);
    }

    public void removeLabel(String label){
        this.labels.remove(label);
    }



}
