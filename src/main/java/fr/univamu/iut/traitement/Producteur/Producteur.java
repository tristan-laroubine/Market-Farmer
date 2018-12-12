package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;

public abstract class Producteur extends Proprietaire {


    UniteDeProduction uniteDeProduction;

    public abstract void setUniteDeProduction(UniteDeProduction uniteDeProduction);


    public UniteDeProduction getUniteDeProduction() {
        return uniteDeProduction;
    }


    public ProduitFermier produitProduit(String type) {
        ProduitFermier produitFermier = uniteDeProduction.produitProduit(type);
        produitFermier.setProprietaire(this);
        this.addProduitFermiers(produitFermier);
        return produitFermier;
    }


    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        ProduitFermier produitFermier = uniteDeProduction.produitProduit(type,arg,arguments);
        produitFermier.setProprietaire(this);

        this.addProduitFermiers(produitFermier);
        return produitFermier;
    }







}
