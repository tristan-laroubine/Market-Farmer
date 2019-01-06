package fr.univamu.iut.test;

import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme;
import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.ProduitArboriculteur;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProduitArboriculteurTest {

    private ProduitArboriculteur produitArboriculteur;
    private List<String> labels = new ArrayList<>();

    @Test
    public final void attributPommeTest()
    {
        produitArboriculteur= new Pomme(labels, 10,25.0);
        assertEquals(produitArboriculteur.getPoids(), 10);
        assertEquals("C'est bon", produitArboriculteur.getPrix(), 25, 0);
        assertEquals(produitArboriculteur.getDatePeremption(),LocalDate.of(1995,10,12));
    }

    @Test
    public final void validerPommeNonPerime()
    {
        produitArboriculteur = new Pomme(labels, 10,25.0);
        assertTrue(produitArboriculteur.valider());
    }

    @Test
    public final void validerPommePerime(){

        produitArboriculteur = new Pomme(labels , 10,25.0);
        assertFalse(produitArboriculteur.valider());
    }
}
