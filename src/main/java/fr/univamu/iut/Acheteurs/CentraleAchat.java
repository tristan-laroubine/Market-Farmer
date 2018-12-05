package fr.univamu.iut.Acheteurs;

import java.util.ArrayList;

public class CentraleAchat extends Acheteur {

    private ArrayList <Acheteur> acheteurs;
    private int promotion;
    private int quantitee;

    public CentraleAchat(String nom)
    {
        this.nom = nom;
    }


    @Override
    public void acheter() {
        //négociation des achats


    }

    public void choixProduits(){

    }

    public void rechercheFournisseurs(){

    }
}
