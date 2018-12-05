package fr.univamu.iut.traitement;

import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

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
