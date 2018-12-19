package fr.univamu.iut.traitement;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class Transaction {
    Proprietaire acheteur;
    Proprietaire vendeur;
    ProduitFermier produitFermier;
    LocalDate localDate;

    public Transaction(Proprietaire acheteur, Proprietaire vendeur, ProduitFermier produitFermier) {
        this.acheteur = acheteur;
        this.vendeur = vendeur;
        this.produitFermier = produitFermier;
        this.localDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return vendeur.getPrenom() + " a vendu à " + acheteur.getPrenom() + " un(e) " + produitFermier + " le " + localDate;
    }
}
