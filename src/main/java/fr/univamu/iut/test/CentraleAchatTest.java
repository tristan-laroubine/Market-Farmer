package fr.univamu.iut.test;
import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
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
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CentraleAchatTest {

    private CentraleAchat centraleAchat = new CentraleAchat();
    private ArrayList<Proprietaire> acheteurs = new ArrayList<>();
    private UniteDeProduction uniteDeProduction = new UniteDeProductionDeViande();
    private Proprietaire p2 = new ProducteurLaitier();
    private Proprietaire p3 = new ProducteurLaitier();
    private MarcheFermier marcheFermier = new MarcheFermier();

    @Test
    public final void achatDeGroupeTest(){
        acheteurs.add(p3);
        acheteurs.add(p2);
        double soldeInitialP2 = p2.getSolde();
        double soldeInitialP3 = p3.getSolde();

        uniteDeProduction = new UniteDeProductionDeViande();
        Proprietaire p = new ProducteurDeViande(uniteDeProduction);
        ProduitFermier produitFermier = ((ProducteurDeViande) p).produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        p.vendre(produitFermier,marcheFermier);

        centraleAchat.achatDeGroupe("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon", acheteurs, marcheFermier);
        assertNotEquals(soldeInitialP2, p2.getSolde());
        assertNotEquals(soldeInitialP3,p3.getSolde());

    }
}
