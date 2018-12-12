package fr.univamu.iut.test;

import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.ProduitApiculteur;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProduitApiculteurTest {

    private ProduitApiculteur produitApiculteur;
    private List<String> labels = new ArrayList<>();

    @Test
    public final void attributMielTest()
    {
        produitApiculteur= new Miel(labels,LocalDate.of(1995,10,12) , 10,25.0);
        assertEquals(produitApiculteur.getPoids(), 10);
        assertEquals("C'est bon", produitApiculteur.getPrix(), 25, 0);
        assertEquals(produitApiculteur.getDatePeremption(),LocalDate.of(1995,10,12));
    }

    @Test
    public final void validerMielNonPerime()
    {
        produitApiculteur = new Miel(labels,LocalDate.of(2020,12,12) , 10,25.0);
        assertTrue(produitApiculteur.valider());
    }

    @Test
    public final void validerMielPerime(){

        produitApiculteur = new Miel(labels,LocalDate.of(2014,12,12) , 10,25.0);
        assertFalse(produitApiculteur.valider());
    }
}
