package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;

public abstract class Producteur extends Proprietaire {



    public abstract void setUniteDeProduction(UniteDeProduction uniteDeProduction);


    public UniteDeProduction getUniteDeProduction() {
        return uniteDeProduction;
    }


    public ProduitFermier produitProduit(String type) {
        return uniteDeProduction.produitProduit(type);
    }


    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        return uniteDeProduction.produitProduit(type,arg,arguments);
    }


    UniteDeProduction uniteDeProduction;




}
