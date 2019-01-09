package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class OffreAchat implements Comparable{

    /**
     * produit fermier de l'offre d'achat
     */
    private ProduitFermier produitFermier;

    /**
     * acheteur de l'offre d'achats
     */
    private Proprietaire acheteur;

    /**
     * date de l'offre d'achat
     */
    private LocalDate dateOffre;

    /**
     * prix de l'offre d'achat
     */
    private double prix;


    //GET

    /**
     * renvoie la date de l'offre d'achat
     * @return LocalDate
     */
    public LocalDate getDateOffre() {
        return dateOffre;
    }

    /**
     * renvoie le prix de l'offre d'achat
     * @return double
     */
    public double getPrix() {
        return this.prix;
    }

    /**
     * renvoie la produit de l'offre d'achat
     * @return ProduitFermier
     */
    public ProduitFermier getProduitFermier() {
        return produitFermier;
    }

    /**
     * renvoie l'acheteur de l'offre d'achat
     * @return Proprietaire
     */
    public Proprietaire getAcheteur() {
        return acheteur;
    }

    //SET

    /**
     * Modifie le prix de l'offre d'achat
     * @param prix correspond au nouveau prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }


    /**
     * constructeur de l'offre d'achat avec les attibuts suivants :
     * @param acheteur
     * @param produitFermier
     */
    public OffreAchat(Proprietaire acheteur, ProduitFermier produitFermier) {
        this.acheteur = acheteur;
        this.produitFermier = produitFermier;
        this.dateOffre = LocalDate.now();
        this.prix = produitFermier.getPrix();

    }

    /**
     * Affiche la date de l'offre d'achat
     * @return String
     */
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
