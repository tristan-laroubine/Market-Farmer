package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

public abstract class Producteur extends Proprietaire {

    public abstract ProduitFermier produitProduit(String type);

    public abstract ProduitFermier produitProduit(String type, String[] arg, Object... arguments);


}
