package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Collection;
import java.util.PriorityQueue;

public class Tradeur implements Observateur {


    @Override
    public String toString() {
        return "Tradeur";
    }


    @Override
    public void update(PriorityQueue<ProduitFermier> produitsFermier) {
        System.out.println("Des éléments du marché on été modifié");
        System.out.println(produitsFermier.peek().getProprietaire().getPrenom());


    }
}
