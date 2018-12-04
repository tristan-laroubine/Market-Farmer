package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.Fermier.ProducteurDeViande;
import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitViande.ProduitViande;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class UniteDeProductionDeViande extends UniteDeProduction {

    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitViande) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitViande) super.produitProduit(type, args, arguments);
    }
}
