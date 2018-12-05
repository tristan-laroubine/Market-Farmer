package fr.univamu.iut.Marché;

import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.Controleur;
import fr.univamu.iut.Producteur.Producteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MarcheFermier extends Marche {


    private TreeSet<Producteur> vendeurs = new TreeSet<>();
    private PriorityQueue <Proprietaire>  acheteurs = new PriorityQueue<>();
    private PriorityQueue<ProduitFermier> produitsFermier = new PriorityQueue<>();
    private PriorityQueue<OffreAchat> offreAchats = new PriorityQueue<>();


    public MarcheFermier(String nom, String region, Controleur controleur)
    {
        super.nom = nom;
        super.region = region;
        super.controleur = controleur;
    }


    public void addOffreToOffreAchats(OffreAchat offreAchat){
        offreAchats.add(offreAchat);
    }
    public void removeOffreToOffreAchats(OffreAchat offreAchat){
        offreAchats.remove(offreAchat);
    }

    public TreeSet<Producteur> getVendeurs() {
        return vendeurs;
    }

    public PriorityQueue <Proprietaire> getAcheteurs() {
        return acheteurs;
    }

    public PriorityQueue<ProduitFermier> getProduitsFermier() {
        return produitsFermier;
    }

    public void setVendeurs(TreeSet<Producteur> vendeurs) {
        this.vendeurs = vendeurs;
    }

    public void setAcheteurs(PriorityQueue <Proprietaire> acheteurs) {
        this.acheteurs = acheteurs;
    }

    public void setProduitsFermier(PriorityQueue<ProduitFermier> produitsFermier) {
        this.produitsFermier = produitsFermier;
    }


    public void addVendeur(Producteur p)
    {
        vendeurs.add(p);
    }

    public void addVendeurs(List<Producteur> ListVendeurs)
    {
        vendeurs.addAll(ListVendeurs);
    }

    public void addAcheteur(Proprietaire acheteur)
    {
        acheteurs.add(acheteur);
    }

    public void addAcheteurs(List <Proprietaire> ListAcheteurs)
    {
        acheteurs.addAll(ListAcheteurs);
    }

    public void addProduit(ProduitFermier produitFermier)
    {
        produitsFermier.add(produitFermier);
    }

    public void addProduits(List<ProduitFermier> ListProduitFermiers)
    {
        produitsFermier.addAll(ListProduitFermiers);
    }



    public void transaction(ProduitFermier produitFermier, Proprietaire acheteur){
        Proprietaire proprietaire = produitFermier.getProprietaire();
        if (acheteur.getSolde() <  produitFermier.getPrix()) return;
        proprietaire.crediter(produitFermier.getPrix());
        acheteur.crediter(-produitFermier.getPrix());
        proprietaire.removeProduitFermiers(produitFermier);
        acheteur.addProduitFermiers(produitFermier);
    }

    @Override
    public String toString() {
        return "MarcheFermier";
    }
}
