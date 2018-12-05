package fr.univamu.iut.ProduitFermier;

import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.Producteur.Producteur;

import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier {

    protected List<String> labels = new ArrayList<>();
    protected  double prix;
    protected  int poids;
    protected Proprietaire proprietaire;

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public boolean valider(){
        return true;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void addLabel(String label){
        this.labels.add(label);
    }

    public void removeLabel(String label){
        this.labels.remove(label);
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

}
