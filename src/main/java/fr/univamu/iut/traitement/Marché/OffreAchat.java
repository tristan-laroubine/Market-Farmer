package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class OffreAchat implements Comparable{

    private ProduitFermier produitFermier;
    private Proprietaire acheteur;
    private LocalDate dateOffre;
    private double prix;


    //GET
    public LocalDate getDateOffre() {
        return dateOffre;
    }
    public double getPrix() {
        return this.prix;
    }

    public ProduitFermier getProduitFermier() {
        return produitFermier;
    }

    public Proprietaire getAcheteur() {
        return acheteur;
    }

    //SET
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setDateOffre(LocalDate dateOffre) {
        this.dateOffre = dateOffre;
    }

    //CONSTRUCT
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

    /**
     * compare deux offres d'achats en fonction de leurs dates
     * @param o correspond à une offre d'achat
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        OffreAchat offreAchat = (OffreAchat) o;
        return -offreAchat.getDateOffre().compareTo(dateOffre);
    }
}
