package fr.univamu.iut.traitement;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class Transaction {
    /**
     * Attribut acheteur
     */
    Proprietaire acheteur;

    /**
     * Attribut vendeur
     */
    Proprietaire vendeur;

    /**
     * Attribut produitFermier
     */
    ProduitFermier produitFermier;

    /**
     * Attribut localDate
     */
    LocalDate localDate;

    /**
     * Constructeur Transaction avec un acheteur, un vendeur
     * et un produit
     * @param acheteur
     * @param vendeur
     * @param produitFermier
     */
    public Transaction(Proprietaire acheteur, Proprietaire vendeur, ProduitFermier produitFermier) {
        this.acheteur = acheteur;
        this.vendeur = vendeur;
        this.produitFermier = produitFermier;
        this.localDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return vendeur.getPrenom() + " a vendu à " + acheteur.getPrenom() + " un(e) " + produitFermier + " le " + localDate + " au prix de " + produitFermier.getPrix() +"€";
    }
}
