package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marche.Marche;
import fr.univamu.iut.traitement.Marche.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;

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

    /**
     *
     * @param nbActeurs correspond au nombre de perssonnes qui achéte le produit,
     *                  plus il y a de personnes, plus la promotion est élevée
     * @param prix correspond au prix actuel du produit
     * @return un double qui correspond à la promotion
     */

    private double getPromotion(int nbActeurs, double prix)
    {
        return (prix * ((100-(double)nbActeurs)/100));
    }

    /**Inflige une sanction a un proprietaire
     *
     * @param amende Le montant de la sanction
     * @param proprietaire Le proprietaire
     */
    public void sanctionArgent(int amende, Proprietaire proprietaire)
    {
        proprietaire.crediter(-amende);
    }

    @Override
    public String toString() {
        return "Centrale d'Achat  ";
    }
}


