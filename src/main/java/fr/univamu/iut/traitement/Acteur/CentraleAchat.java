package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat extends Proprietaire {

    /**
     *
     * achatDeGroupe permet à plusieurs acheteurs d'acheter le produit de type choisi le moins cher
     * et de le partager équitablement en bénéficient d'une promotion
     * Les soldes des vendeurs et des acheteurs sont mis à jour
     *
      * @param type le type de produit que l'on veut acheter
     * @param acheteurs le nombre d'acheteurs associès
     * @param marche le type de marché
     */
    public void achatDeGroupe(String type, ArrayList<Proprietaire> acheteurs, Marche marche){
        if(marche instanceof MarcheFermier)
        {
            if(((MarcheFermier) marche).isProduitForThatType(type))
            {
                ProduitFermier produitFermier = ((MarcheFermier) marche).getProduitMoinsChereByType(type);
                produitFermier.getProprietaire().crediter(produitFermier.getPrix());
                produitFermier.getProprietaire().removeProduitFermiers(produitFermier);
                ((MarcheFermier) marche).removeProduitFermier(produitFermier);
                ArrayList<Proprietaire> acheteursCopy = new ArrayList<>();
                acheteursCopy.addAll(acheteurs);
                for ( Proprietaire acheteur : acheteurs
                     ) {
                    if(produitFermier.getProprietaire() == acheteur )
                    {
                        acheteursCopy.remove(acheteur);
                    }
                }
                for (Proprietaire proprietaire: acheteursCopy
                ) {
                    ProduitFermier produitFermier1 = (ProduitFermier) produitFermier.divideBy(acheteursCopy.size());
                    produitFermier1.setProprietaire(proprietaire);
                    proprietaire.addProduitFermiers(produitFermier1);
                    proprietaire.crediter(-getPromotion(acheteursCopy.size(), produitFermier1.getPrix()));
                }
            }
        }

    }
    private double getPromotion(int nbActeurs, double prix)
    {
        return (prix * (((double)nbActeurs+10)/100));
    }

    @Override
    public String toString() {
        return "Centrale d'Achat";
    }
}


