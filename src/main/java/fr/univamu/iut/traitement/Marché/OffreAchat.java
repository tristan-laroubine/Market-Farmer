package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class OffreAchat implements Comparable{

    private ProduitFermier produitFermier;
    private Proprietaire acheteur;

    public LocalDate getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(LocalDate dateOffre) {
        this.dateOffre = dateOffre;
    }

    private LocalDate dateOffre;

    public double getPrix() {
        return this.prix;
    }

    private double prix;

    public ProduitFermier getProduitFermier() {
        return produitFermier;
    }

    public Proprietaire getAcheteur() {
        return acheteur;
    }

    public OffreAchat(Proprietaire acheteur, ProduitFermier produitFermier) {
        this.acheteur = acheteur;
        this.produitFermier = produitFermier;
        this.dateOffre = LocalDate.now();
        this.prix = produitFermier.getPrix();

    }
    @Override
    public String toString() {
        return "Offre Achat" + dateOffre;
    }

    @Override
    public int compareTo(Object o) {
        OffreAchat offreAchat = (OffreAchat) o;
        return -offreAchat.getDateOffre().compareTo(dateOffre);
    }
}
