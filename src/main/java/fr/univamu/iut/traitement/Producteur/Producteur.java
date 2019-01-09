package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;

import java.util.ArrayList;

public abstract class Producteur extends Proprietaire {


    /**
     * attribut unite de production
     */
    UniteDeProduction uniteDeProduction;

    /**
     * Setteur unité de production
     * @param uniteDeProduction
     */
    public abstract void setUniteDeProduction(UniteDeProduction uniteDeProduction);

    /**
     * Getteur unité de production
     * @return
     */
    public UniteDeProduction getUniteDeProduction() {
        return uniteDeProduction;
    }

    /**
     * crée un produit avec le type associé
     * @param type correspond au type de produit que l'on veut créer
     * @return ProduitFermier
     */
    public ProduitFermier produitProduit(String type) {
        ProduitFermier produitFermier = uniteDeProduction.produitProduit(type);
        produitFermier.setProprietaire(this);
        this.addProduitFermiers(produitFermier);
        return produitFermier;
    }

    /**
     * Crée un produit avec les paramètres suivants
     * @param type correspond au type du produit
     * @param arg
     * @param arguments
     * @return
     */
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        ProduitFermier produitFermier = uniteDeProduction.produitProduit(type,arg,arguments);
        produitFermier.setProprietaire(this);

        this.addProduitFermiers(produitFermier);
        return produitFermier;
    }


}
