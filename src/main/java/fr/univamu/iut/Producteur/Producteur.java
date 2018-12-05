package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

abstract class Producteur {
    public abstract ProduitFermier produitProduit(String type);

    public abstract ProduitFermier produitProduit(String type, String[] arg, Object... arguments);

}
