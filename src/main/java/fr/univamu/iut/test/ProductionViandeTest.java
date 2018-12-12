package fr.univamu.iut.test;

import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.ProduitViande;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductionViandeTest {

    private ProduitViande produitViande;
    private List<String> labels = new ArrayList<>();

    @Test
    public final void testAttributCochon()
    {
        produitViande = new Cochon(labels, 100, 50.0);
        assertEquals("C'est bon", 50, produitViande.getPrix(), 0);
        assertEquals("C'est bon", 100, produitViande.getPoids(), 0);
        assertEquals(labels.getClass(), ArrayList.class);
    }

    @Test
    public final void testAttributVache()
    {
        produitViande = new Vache(labels,100,50.0);
        assertEquals("C'est bon", 50, produitViande.getPrix(), 0);
        assertEquals("C'est bon", 100, produitViande.getPoids(), 0);
        assertEquals(labels.getClass(), ArrayList.class);

    }

    @Test
    public final void testValiderCochon()
    {
        produitViande = new Cochon(labels, 100,50.0);
        assertTrue(produitViande.valider());
    }

    @Test
    public final void testValiderVache()
    {
        produitViande = new Vache(labels,100,50.0);
        assertTrue(produitViande.valider());
    }
}

