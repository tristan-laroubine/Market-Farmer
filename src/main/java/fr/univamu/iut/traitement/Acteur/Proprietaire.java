package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Proprietaire {

    private String Prenom;

    private double solde = 1000;
    private List<ProduitFermier> produitFermiers = new ArrayList<>();


    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


    public void addProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.add(produitFermier);
    }
    public void removeProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.remove(produitFermier);
    }

    public List<ProduitFermier> getProduitFermiers() {
        return produitFermiers;
    }

    public void setProduitFermiers(List<ProduitFermier> produitFermiers) {
        this.produitFermiers = produitFermiers;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void crediter(double prix) {
        solde += prix;
    }

    public void vendre(ProduitFermier produitFermier, MarcheFermier marche)
    {
        if(produitFermier.getProprietaire() == this) {
            marche.addProduit(produitFermier);
        }
        else System.out.println("Mauvais Proprietaire" + produitFermier.getProprietaire() + this);
    }

    public void proposerOffre(MarcheFermier marche, ProduitFermier produitFermier)
    {
        System.out.println(produitFermier.getProprietaire().getPrenom() + " != " +  this.Prenom);
        if(produitFermier.getProprietaire() == this) {
            System.out.println("Mauvais proprietaire");
            return;
        }
        for (OffreAchat offreAchat: marche.getOffreAchats()
             ) {
            if (offreAchat.getProduitFermier() == produitFermier)
            {
                System.out.println("Offre déja en vente");
                return;
            }
        }
        PriorityQueue<OffreAchat> offreAchats = marche.getOffreAchats();
        OffreAchat offreAchat = new OffreAchat(this,produitFermier);
        if (marche.getControleur().valide(offreAchat))
        {
            marche.addOffreToOffreAchats(offreAchat);
        }
    }




}
