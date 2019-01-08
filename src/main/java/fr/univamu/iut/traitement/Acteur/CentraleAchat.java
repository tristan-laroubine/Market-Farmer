package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.Iterator;

public class CentraleAchat extends Proprietaire {

    public void achatDeGroupe(String type, ArrayList<Proprietaire> acheteurs, Marche marche){
        if(marche instanceof MarcheFermier)
        {
            System.out.println(acheteurs);
            if(((MarcheFermier) marche).isProduitForThatType(type))
            {
                ProduitFermier produitFermier = ((MarcheFermier) marche).getProduitMoinsChereByType(type);
                produitFermier.getProprietaire().setSolde(produitFermier.getProprietaire().getSolde() + produitFermier.getPrix());
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
                    proprietaire.setSolde(proprietaire.getSolde() - produitFermier1.getPrix());
                }
            }
        }

    }



    }


