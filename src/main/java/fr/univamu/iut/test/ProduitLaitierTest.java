package fr.univamu.iut.test;

import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait;
import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.ProduitLaitier;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProduitLaitierTest {

    private ProduitLaitier produitLaitier;
    private List<String> labels = new ArrayList<>();

    @Test
    public final void attributLaitTest()
    {
        produitLaitier = new Lait(labels,LocalDate.of(1995,10,12) , 10,25.0);
        assertEquals(produitLaitier.getPoids(), 10);
        assertEquals("C'est bon",produitLaitier.getPrix(), 25, 0);
        assertEquals(produitLaitier.getDatePeremption(),LocalDate.of(1995,10,12));
    }

    @Test
    public final void validerLaitNonPerime()
    {
        produitLaitier = new Lait(labels,LocalDate.of(2020,12,12) , 10,25.0);
        assertTrue(produitLaitier.valider());
    }

    @Test
    public final void validerLaitPerime(){

        produitLaitier = new Lait(labels,LocalDate.of(2014,12,12) , 10,25.0);
        assertFalse(produitLaitier.valider());
    }
}
