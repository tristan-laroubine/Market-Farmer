package fr.univamu.iut.Marché;

import fr.univamu.iut.Controleur;
import fr.univamu.iut.Fermier.Producteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.util.ArrayList;

public class MarcheFermier extends Marche {

    private Controleur c;

    private ArrayList <Producteur> vendeurs;
    private ArrayList <Acheteur>  acheteurs;

    //UNE MAP POUR LES DEUX ????
    private ArrayList<ProduitFermier> produitsFermier;
    private ArrayList<Offre> offres;



    public MarcheFermier(String nom, String region, Controleur c)
    {
        super.nom = nom;
        super.region = region;
        this.c = c;
    }



}
