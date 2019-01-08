package fr.univamu.iut.traitement.ProduitFermier;

import fr.univamu.iut.traitement.Acteur.Proprietaire;

import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier implements Comparable, Cloneable{

    /**
     * Les labels du produit
     */
    protected List<String> labels = new ArrayList<>();

    /**
     * Le prix du produit
     */
    protected  double prix = 50;

    /**
     * Le poids du produit
     */
    protected  int poids;

    /**
     * Le Proprietaire du produit
     */
    protected Proprietaire proprietaire;

    /**
     * Acceceur du proprietaire
     * @return le propriétaire
     */
    public Proprietaire getProprietaire() {
        return proprietaire;
    }
    /**
     * Setter du proprietaire
     * @return le propriétaire
     */
    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * dit si le produit est valider ou non
     * @return true or false (true default)
     */
    public boolean valider(){
        return true;
    }

    /**
     * Acceseur de la list du Labels
     * @return la list de Labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * setter labels
     * @param labels List des Labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     * Ajouter un Label à la list
     * @param label le label à ajouté
     */
    public void addLabel(String label){
        this.labels.add(label);
    }

    /**
     * Enleve le label
     * @param label Label de la list
     */
    public void removeLabel(String label){
        this.labels.remove(label);
    }

    /**
     * donne le prix
     * @return le prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * modifie le prix
     * @param prix le prix du produit
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     * retourn le poid du produit
      * @return le poids du produit
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Modifie le poids du produit
     * @param poids le poids du produit
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Compare les produits en eux
     * @param that le produit à comparer
     * @return la difference
     */
    public int compareTo(Object that){
        ProduitFermier produitFermier = (ProduitFermier) that;
        if (prix - produitFermier.getPrix()!=0){
            return (int) (prix - produitFermier.getPrix());
        }
        return 0;
    }

    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la
            // méthode super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }
    public Object divideBy(int number) {
        ProduitFermier o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la
            // méthode super.clone()
            o = (ProduitFermier) super.clone();
            o.setPrix((int) (o.getPrix()/number));
            o.setPoids(o.getPoids()/number);
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }
}
