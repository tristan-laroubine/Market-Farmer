package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Proprietaire implements StrategyCom{

    private String Prenom;
    private double solde = 1000;
    private List<ProduitFermier> produitFermiers = new ArrayList<>();
    private ArrayList<String> typesInteresse = new ArrayList<>();

    //GET

    public String getPrenom() {
        return Prenom;
    }

    public double getSolde() {
        return solde;
    }

    public List<ProduitFermier> getProduitFermiers() {
        return produitFermiers;
    }

    //SET
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setProduitFermiers(List<ProduitFermier> produitFermiers) {
        this.produitFermiers = produitFermiers;
    }

    public void addProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.add(produitFermier);
    }
    public void removeProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.remove(produitFermier);
    }


    /**
     * ajoute un prix au solde actuel
     * @param prix
     */

    public void crediter(double prix) {
        solde += prix;
    }

    /**
     * Un proprietaire d'un produit va proposer une offre de vente dans le marché
     * @param produitFermier correspond au produit que le proprétaire veut vendre
     * @param marche correspond au marché ou le produit doit être vendu
     */

    public void vendre(ProduitFermier produitFermier, MarcheFermier marche)
    {
        if(produitFermier.getProprietaire() == this) {

            if(marche.findProduitInProduits(produitFermier))
            {
                System.out.println("Produit déjà en vente");
                return;
            }
            marche.addProduit(produitFermier);
        }
        else System.out.println("Mauvais Proprietaire" + produitFermier.getProprietaire() + this);
    }


    /**
     * Un acheteur va proposer une offre d'achat pour un produit du marché
     * @param marche correpond au marché ou l'offre d'achat est effectuée
     * @param produitFermier correspond au produit qui ou l'acheteur veut proposer une offre
     */
    public void proposerOffre(MarcheFermier marche, ProduitFermier produitFermier)
    {
        if(produitFermier.getProprietaire() == this) {
            System.out.println("Mauvais proprietaire");
            return;
        }
        if(marche.isDejaOffreEnCours(this,produitFermier))
        {
            return;
        }
        //PriorityQueue<OffreAchat> offreAchats = marche.getOffreAchats();
        OffreAchat offreAchat = new OffreAchat(this,produitFermier);
        if (marche.getControleur().valide(offreAchat))
        {
            marche.addOffreToOffreAchats(offreAchat);
        }
    }


    public void addTypes(String type)
    {
        if(isFindInTypeInteresse(type)) typesInteresse.add(type);
    }
    boolean isFindInTypeInteresse(String type)
    {
        for(String s : typesInteresse)
        {
            if(s.equals(type)) return true;
        }
        return false;
    }
    public void notification(ProduitFermier produitFermier)
    {
        if (!isFindInTypeInteresse(produitFermier.getClass().getTypeName()))
        {
            System.out.println(getPrenom()+" => Produit de votre abonnement ajouté au marché ! => " + produitFermier);
        }
    }



}
