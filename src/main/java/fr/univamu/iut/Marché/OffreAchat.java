package fr.univamu.iut.Marché;

import fr.univamu.iut.Acheteurs.Acheteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.time.LocalDate;

public class OffreAchat {

    private ProduitFermier produitFermier;
    private Marche marche;
    private Acheteur a;
    private LocalDate dateOffre;


    public OffreAchat(Acheteur a, ProduitFermier produitFermier, Marche marche, LocalDate dateOffre) {
        this.a = a;
        this.produitFermier = produitFermier;
        this.marche = marche;
        this.dateOffre = dateOffre;

    }

    public void effectuerTransaction(){

        //debiter et crediter

    }




}
