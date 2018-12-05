package fr.univamu.iut.traitement.ProduitFermier;

import fr.univamu.iut.traitement.Acteur.Proprietaire;

import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier implements Comparable {

    protected List<String> labels = new ArrayList<>();
    protected  double prix = 50;
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

    public int compareTo(Object that){
        ProduitFermier produitFermier = (ProduitFermier) that;
        if (prix - produitFermier.getPrix()!=0){
            return (int) (prix - produitFermier.getPrix());
        }
        return 0;
    }

}
