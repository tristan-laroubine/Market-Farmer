package fr.univamu.iut.ProduitFermier.ProduitViande;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cochon extends ProduitViande {
    List<String> labels = new ArrayList<>();

    int poids;


    public Cochon(){

    }

    public Cochon(List<String> labels, LocalDate datePeremption, int poids) {
        this.labels = labels;

        this.poids = poids;
    }

    public Cochon(LocalDate datePeremption, Integer poids) {

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

    @Override
    public boolean valider() {
        if (1==1){
            return true;
        }
        return false;
    }


}
