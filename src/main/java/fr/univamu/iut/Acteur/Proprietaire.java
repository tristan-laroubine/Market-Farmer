package fr.univamu.iut.Acteur;

import fr.univamu.iut.Marché.Marche;
import fr.univamu.iut.Marché.MarcheFermier;
import fr.univamu.iut.Marché.OffreAchat;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.List;

public abstract class Proprietaire {
    private double solde = 1000;
    private List<ProduitFermier> produitFermiers = new ArrayList<>();

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

    public void proposerOffre(MarcheFermier marche, ProduitFermier produitFermier)
    {
        OffreAchat offreAchat = new OffreAchat(this,produitFermier);
        if (marche.getControleur().valide(offreAchat))
        {
            marche.addOffreToOffreAchats(offreAchat);
        }
    }


}
