package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat extends Proprietaire {

    private ArrayList<Proprietaire> acheteurs;



    private ArrayList<OffreAchat> offresChoisies = new ArrayList<>();




    private int promotion;
    private int quantitee;

    public ArrayList<OffreAchat> getOffresChoisies() {
        return this.offresChoisies;

    }
    public void choixProduits(ArrayList<OffreAchat> offreAchats, String p) {

        for (OffreAchat of : offreAchats) {
            try {
                if (of.getProduitFermier().getClass() == Class.forName(p)) {
                    offresChoisies.add(of);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion() {
        //pour 4 cochons on pourra faire une promotion de 4% (4/100)
        this.promotion = offresChoisies.size();
    }

    public void promotion(){

        for ( OffreAchat of : this.offresChoisies)
        {
            double prix = of.getPrix()-(this.getPromotion()/100);
            of.setPrix(of.getPrix()-prix);
            System.out.println(prix);
        }
    }


}
