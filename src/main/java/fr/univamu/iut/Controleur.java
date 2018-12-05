package fr.univamu.iut;

import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.Marché.OffreAchat;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.util.PriorityQueue;

public class Controleur {

    public OffreAchat choisirAcheteur(PriorityQueue<OffreAchat> offreAchats, ProduitFermier produitFermier){
        for (OffreAchat offreAchat : offreAchats) {
            if(offreAchat.getProduitFermier() == produitFermier )
            {
                return offreAchat;
            }
        }
        return null;
    }
    public boolean valide(OffreAchat offreAchat)
    {
        return true;
    }


}
