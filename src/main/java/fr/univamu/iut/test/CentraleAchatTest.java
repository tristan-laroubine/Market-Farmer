package fr.univamu.iut.test;
import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CentraleAchatTest {

    @Test
    public final void getOffresTest(){
        CentraleAchat centraleAchat= new CentraleAchat();
        Proprietaire proprietaire1 = new ProducteurDeViande();
        ArrayList<OffreAchat> offreAchats = new ArrayList<>();
        offreAchats.add(new OffreAchat(proprietaire1,new Vache(50, (double) 500)));
        offreAchats.add(new OffreAchat(proprietaire1,new Cochon(50, (double) 500)));
        centraleAchat.choixProduits(offreAchats, "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");

        assertSame(centraleAchat.getOffresChoisies().get(0).getProduitFermier().getClass(),Cochon.class);
    }
}
