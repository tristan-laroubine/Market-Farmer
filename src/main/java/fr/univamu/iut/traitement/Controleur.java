package fr.univamu.iut.traitement;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.PriorityQueue;

public class Controleur {

    /**
     * Choisi le premier acheteur du produit passé en paramétre
     * @param offreAchats correspond à l'offre d'achat
     * @param produitFermier correspond au produit dont on veut le prmier acheteur
     * @return OffreAchat
     */
    public OffreAchat choisirAcheteur(PriorityQueue<OffreAchat> offreAchats, ProduitFermier produitFermier){
        for (OffreAchat offreAchat : offreAchats) {
            if(offreAchat.getProduitFermier() == produitFermier )
            {
                return offreAchat;
            }
        }
        return null;
    }

    /**
     * Valide la vente
     * @param offreAchat correspond à l'offre d'achat avant la vente
     * @return boolean
     */
    public boolean valide(OffreAchat offreAchat)
    {
        return true;
    }

    /**
     * Sanctionne un proprietaire
     * @param proprietaire le proprietaire sanctionner
     */
    public void sanction(Proprietaire proprietaire)
    {
        proprietaire.crediter(-100);
    }

}
