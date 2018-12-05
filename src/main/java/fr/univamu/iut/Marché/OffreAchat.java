package fr.univamu.iut.Marché;

import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class OffreAchat {

    private ProduitFermier produitFermier;
    private Proprietaire acheteur;
    private LocalDate dateOffre;
    private double prix;


    public OffreAchat(Proprietaire acheteur, ProduitFermier produitFermier) {
        this.acheteur = acheteur;
        this.produitFermier = produitFermier;
        this.dateOffre = LocalDate.now();
        this.prix = produitFermier.getPrix();

    }
    @Override
    public String toString() {
        return "Offre Achat";
    }
}
