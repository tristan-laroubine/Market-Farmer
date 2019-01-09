package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;

import java.util.ArrayList;
import java.util.List;

public abstract class Proprietaire implements StrategyCom{

    private int stock = 0;

    /**
     * prenom du proprietaire
     */
    private String Prenom;

    /**
     * solde du proprietaire
     */
    private double solde = 1000;

    /**
     * liste des produits que possède un proprietaire
     */
    private List<ProduitFermier> produitFermiers = new ArrayList<>();

    /**
     * Liste des produits dont le propriétaire veut être notifié à l'arrivée dans le marché
     */
    private ArrayList<String> typesInteresse = new ArrayList<>();

    //GET

    /**
     * renvoie le prenom du proprietaire
     * @return String
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * renvoie le solde du proprietaire
     * @return double
     */
    public double getSolde() {
        return solde;
    }

    /**
     * renvoie la liste des produits possédès par le proprietaire
     * @return List<ProduitFermier>
     */
    public List<ProduitFermier> getProduitFermiers() {
        return produitFermiers;
    }

    //SET

    public void setStock(int stock)
    {
        this.stock = this.stock + stock;
        System.out.println(this.stock);
    }

    /**
     * modifie le prenom du proprietaire
     * @param prenom correspond au nouveau prenom
     */
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    /**
     * modifie le solde du proprietaire
     * @param solde correspondant au nouveau solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * modifie la liste des produits possédés par le proprietaire
     * @param produitFermiers correspondant à la nouvelle liste
     */
    public void setProduitFermiers(List<ProduitFermier> produitFermiers) {
        this.produitFermiers = produitFermiers;
    }

    /**
     * ajoute un produit à la liste des produit possédés par le proprietaire
     * @param produitFermier correspondant au produit à ajouter
     */

    public void addProduitFermiers(ProduitFermier produitFermier){
        produitFermiers.add(produitFermier);
    }

    /**
     * supprime un produit à la liste des produits possédés par le proprietaire
     * @param produitFermier correspond au produit à supprimer
     */
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

    /**
     * ajoute des type de produits au produis suivvis par le proprietaire
     * @param type correspondant au type de produit à ajouter
     */
    public void addTypes(String type)
    {
        if(!isFindInTypeInteresse(type)) typesInteresse.add(type);
    }

    /**
     * renvoie true si le type de produit est trouvé dans la liste des types intéressés
     * @param type correspond au type de produit à chercher
     * @return boolean
     */
    private boolean isFindInTypeInteresse(String type)
    {
        for(String s : typesInteresse)
        {
            if(s.equals(type)) return true;
        }
        return false;
    }

    /**
     * notifie le proprietaire qu'il veut recevoir les notifications de ce type de produit
     * @param produitFermier correspond au type de produit a chercher
     */
    public void notification(ProduitFermier produitFermier)
    {
        if (isFindInTypeInteresse(produitFermier.getClass().getTypeName()))
        {
            System.out.println(getPrenom()+" => Produit de votre abonnement ajouté au marché ! => " + produitFermier);
        }
    }


    public ArrayList<String> getTypes(){
        return typesInteresse;
    }
}
