package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.OffreAchat;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat {

    private ArrayList <Proprietaire> acheteurs;
    private ArrayList<OffreAchat> offreAchats = new ArrayList<OffreAchat>();
    private Iterator<OffreAchat> it = offreAchats.iterator();
    private ArrayList <OffreAchat> offresChoisies = null;
    private Iterator it2  = offresChoisies.iterator();
    private Iterator it3 = offreAchats.iterator();

    private int promotion;
    private int quantitee;

        public void choixProduits(ArrayList<OffreAchat> offreAchats){

            double prixtotal = 0;

            while (it.hasNext()){
                OffreAchat offreAchat = (OffreAchat) it.next();
                //prixtotal ajoute chaque pris de tous les produits de la liste
                prixtotal += offreAchat.getPrix();
            }

            //renvoie la moyenne des prix de tous les produits.
            prixtotal /= offreAchats.size();

            while (it3.hasNext()){
                //choisi les produits
                OffreAchat offreAchat = (OffreAchat) it3.next();

                if(offreAchat.getPrix() <= prixtotal ) {
                    OffreAchat offreAchat1 = (OffreAchat) it2.next();
                    offresChoisies.add(offreAchat);
                }
            }

        }



    public void rechercheFournisseurs(){

    }
}
