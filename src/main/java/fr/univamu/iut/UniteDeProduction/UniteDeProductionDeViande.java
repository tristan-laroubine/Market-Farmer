package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.Fermier.ProducteurDeViande;
import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitViande.ProduitViande;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;

public class UniteDeProductionDeViande extends UniteDeProduction {

    public ProduitViande produitProduit(String type) {
        System.out.println("i'm fine");
        switch (type)
        {
            case "Vache" :
                Vache vache = new Vache(null);
                vache.valider();
                if (vache.isCertifier()) {
                    System.out.println(vache);
                    return vache;
                }

        }

        return null;
    }
}
