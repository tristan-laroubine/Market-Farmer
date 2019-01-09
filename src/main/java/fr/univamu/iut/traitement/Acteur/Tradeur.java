package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Collection;
import java.util.PriorityQueue;

public class Tradeur extends Proprietaire implements Observateur {


    @Override
    public String toString() {
        return "Tradeur";
    }

    /**
     * fonction update du design pattern observateur qui permet d'avoir toutes les informations du marché
     * @param produitsFermier correspond à la liste des produits du marché
     */
    @Override
    public void update(PriorityQueue<ProduitFermier> produitsFermier) {
        System.out.println("Des éléments du marché on été modifié");
        System.out.println(produitsFermier.peek().getProprietaire().getPrenom());
    }

    @Override
    public double comissionMarchePourcentage(double benefice) {
        return benefice*0.05;
    }
}
