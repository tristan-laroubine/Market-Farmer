package fr.univamu.iut.Producteur;

import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

public abstract class Producteur extends Proprietaire {
    public abstract ProduitFermier produitProduit(String type);

    public abstract ProduitFermier produitProduit(String type, String[] arg, Object... arguments);


}
