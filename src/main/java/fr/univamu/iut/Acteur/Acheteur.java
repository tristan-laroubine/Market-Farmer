package fr.univamu.iut.Acteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.util.ArrayList;

public abstract class Acheteur extends Proprietaire{

    protected String nom;

    ArrayList<ProduitFermier> produitFermiers;

    public void addProduitToProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.add(produitFermier);
    }

    public void remooveProduitToProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.remove(produitFermier);
    }


    public abstract void acheter();

    public abstract void debiter();



}
