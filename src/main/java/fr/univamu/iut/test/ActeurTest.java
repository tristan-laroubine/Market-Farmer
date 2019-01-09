package fr.univamu.iut.test;
import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Grossiste;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.Producteur.ProducteurLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import static org.junit.Assert.*;

import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ActeurTest {

    private CentraleAchat centraleAchat = new CentraleAchat();
    private ArrayList<Proprietaire> acheteurs = new ArrayList<>();
    private UniteDeProduction uniteDeProduction = new UniteDeProductionDeViande();
    private Proprietaire p2 = new ProducteurLaitier();
    private Proprietaire p3 = new ProducteurLaitier();
    private MarcheFermier marcheFermier = new MarcheFermier();
    private double soldeInitialP2 = p2.getSolde();
    private double soldeInitialP3 = p3.getSolde();


    @Before
    public final void init(){
        acheteurs.add(p3);
        acheteurs.add(p2);

        uniteDeProduction = new UniteDeProductionDeViande();
        marcheFermier.setControleur(new Controleur());
        Proprietaire p = new ProducteurDeViande(uniteDeProduction);
        ProduitFermier produitFermier = ((ProducteurDeViande) p).produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        p.vendre(produitFermier,marcheFermier);
    }
    @Test
    public final void achatDeGroupeTest(){

        centraleAchat.achatDeGroupe("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon", acheteurs, marcheFermier);
        assertNotEquals(soldeInitialP2, p2.getSolde());
        assertNotEquals(soldeInitialP3,p3.getSolde());

    }

    @Test
    public final void proposeOffreGrandeQuantite(){

        Grossiste g = new Grossiste();
        int nbOffreAchat = marcheFermier.getOffreAchats().size();
        g.proposerOffreEnGrandeQuantitee(marcheFermier, "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon", 200.0, 500.0);
        assertNotEquals(nbOffreAchat, marcheFermier.getOffreAchats().size());

    }
}
