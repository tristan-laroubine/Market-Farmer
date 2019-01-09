package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marche.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Grossiste extends Proprietaire {

    /**
     * propose des offres pour le type de produit choisi tant que le soldeMax est plus grand que 0
     *
     * @param marcheFermier
     * @param type correspond au type de produit que l'on veut acheter
     * @param prixMax correspond au prix maximum d'un type de produit
     * @param soldeMax correspond au solde maximum de l'acheteur
     */
    public void proposerOffreEnGrandeQuantitee(MarcheFermier marcheFermier, String type, Double prixMax, Double soldeMax) {
        if (this.getSolde() > soldeMax) soldeMax = this.getSolde();
        Comparator<ProduitFermier> produitFermierComparator = (s1, s2) -> (int) (s1.getPoids()/s1.getPrix() - s2.getPoids()/s2.getPrix());
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
            if (!marcheFermier.isDejaOffreEnCours(this,produitFermier)){
                soldeMax = soldeMax - produitFermier.getPrix();
                proposerOffre(marcheFermier,produitFermier);
            }
        }
    }


    @Override
    public String toString() {
        return "Grossiste";
    }
}
