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
        produitApiculteur= new Miel(labels , 10,25.0);
        assertEquals(produitApiculteur.getPoids(), 10);
        assertEquals("C'est bon", produitApiculteur.getPrix(), 25, 0);
    }

    @Test
    public final void validerMielNonPerime()
    {
        produitApiculteur = new Miel(labels , 10,25.0);
        assertTrue(produitApiculteur.valider());
    }

    @Test
    public final void validerMielPerime(){

        produitApiculteur = new Miel(labels , 10,25.0);
        produitApiculteur.setDatePeremption(LocalDate.of(1500,5,2));
        assertFalse(produitApiculteur.valider());
    }
}
