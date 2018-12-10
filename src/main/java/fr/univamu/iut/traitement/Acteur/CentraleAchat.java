package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.OffreAchat;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat {

    private ArrayList <Proprietaire> acheteurs;
    private ArrayList<OffreAchat> offreAchats = new ArrayList<OffreAchat>;
    private Iterator<OffreAchat> it = offreAchats.iterator();

    private int promotion;
    private int quantitee;


    public void choixProduits(ArrayList<OffreAchat> offreAchats){

        double prixtotal = 0;
        while (it.hasNext()){
            OffreAchat offreAchat = it.next();
            prixtotal += offreAchat.get

        }

    }

    public void rechercheFournisseurs(){

    }
}
