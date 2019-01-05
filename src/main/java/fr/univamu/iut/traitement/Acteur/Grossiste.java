package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Grossiste extends Proprietaire {


    public void proposerOffreEnGrandeQuantitee(MarcheFermier marcheFermier, String type, Double prixMax, Double soldeMax) {
        if (this.getSolde() > soldeMax) soldeMax = this.getSolde();
        Comparator<ProduitFermier> produitFermierComparator = (s1, s2) -> (int) (s1.getPrix() - s2.getPrix());
        PriorityQueue<ProduitFermier> produitFermierPriorityQueue = new PriorityQueue<>(produitFermierComparator);
        if (soldeMax > getSolde()) soldeMax = getSolde();
        for (ProduitFermier produitfermier : marcheFermier.getProduitsFermier()) {
            try {
                if(produitfermier.getClass() == Class.forName(type) && produitfermier.getPrix()<=prixMax){
                    produitFermierPriorityQueue.add(produitfermier);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        while(!produitFermierPriorityQueue.isEmpty() && soldeMax>=0 ){
            ProduitFermier produitFermier = produitFermierPriorityQueue.remove();
            if (!isDejaEnOffre(marcheFermier,produitFermier)){
                soldeMax = soldeMax - produitFermier.getPrix();
                proposerOffre(marcheFermier,produitFermier);
            }
        }
    }

}
