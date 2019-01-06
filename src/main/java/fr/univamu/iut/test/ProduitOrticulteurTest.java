package fr.univamu.iut.test;

import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProduitOrticulteurTest {

    private ProduitOrticulteur produitOrticulteur;
    private List<String> labels = new ArrayList<>();


    @Test
    public final void attributPommeDeTerreTest()
    {
        produitOrticulteur = new PommeDeTerre(labels , 10,25.0);
        assertEquals(produitOrticulteur.getPoids(), 10);
        assertEquals("C'est bon",produitOrticulteur.getPrix(), 25, 0);
        assertEquals(produitOrticulteur.getDatePeremption(),LocalDate.of(1995,10,12));
    }

    @Test
    public final void validerPommeDeTerre()
    {
        produitOrticulteur = new PommeDeTerre(labels , 10,25.0);
        assertTrue(produitOrticulteur.valider());
    }
}
