package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat {

    private ArrayList<Proprietaire> acheteurs;

    public ArrayList<OffreAchat> getOffresChoisies() {
        System.out.println(this.promotion);
        return this.offresChoisies;

    }

    private ArrayList<OffreAchat> offresChoisies = new ArrayList<>();


    private int promotion;
    private int quantitee;

    public void choixProduits(ArrayList<OffreAchat> offreAchats, ProduitFermier p) {

        for (OffreAchat of : offreAchats) {
            if (of.getProduitFermier() == p) {
                offresChoisies.add(of);
                System.out.println("boucle choix produits");
            }
        }


    }


    public void rechercheFournisseurs() {

    }

}
