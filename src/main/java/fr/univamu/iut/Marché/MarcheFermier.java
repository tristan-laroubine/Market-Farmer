package fr.univamu.iut.Marché;

import fr.univamu.iut.Controleur;
import fr.univamu.iut.Fermier.Producteur;
import fr.univamu.iut.Producteur.Producteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.TreeSet;

public class MarcheFermier extends Marche {

    private Controleur c;

    private TreeSet<Producteur> vendeurs;
    private TreeSet <Acheteur>  acheteurs;
    private TreeSet <ProduitFermier> produitsFermier;



    public MarcheFermier(String nom, String region, Controleur c)
    {
        super.nom = nom;
        super.region = region;
        this.c = c;
    }

    public TreeSet<Producteur> getVendeurs() {
        return vendeurs;
    }

    public TreeSet<Acheteur> getAcheteurs() {
        return acheteurs;
    }

    public TreeSet<ProduitFermier> getProduitsFermier() {
        return produitsFermier;
    }

    public void setVendeurs(TreeSet<Producteur> vendeurs) {
        this.vendeurs = vendeurs;
    }

    public void setAcheteurs(TreeSet<Acheteur> acheteurs) {
        this.acheteurs = acheteurs;
    }

    public void setProduitsFermier(TreeSet<ProduitFermier> produitsFermier) {
        this.produitsFermier = produitsFermier;
    }


    public void addVendeur(Producteur p)
    {
        vendeurs.add(p);
    }

    public void addVendeurs(TreeSet<Producteur> vendeurs)
    {
        vendeurs.addAll(vendeurs);
    }

    public void addAcheteur(Acheteur a)
    {
        acheteurs.add(a);
    }

    public void addAcheteurs(TreeSet<Acheteur> acheteurs)
    {
        acheteurs.addAll(acheteurs);
    }

    public void addProduit(ProduitFermier pf)
    {
        produitsFermier.add(pf);
    }

    public void addProduits(TreeSet<ProduitFermier> pFermiers)
    {
        produitsFermier.addAll(pFermiers);
    }
}
