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

    private ProduitViande produitProduitSpe(String type) {
        try{
            Class<?> classe = Class.forName("fr.univamu.iut.ProduitFermier.ProduitViande."+type);
            java.lang.reflect.Constructor constructeur = classe.getConstructor ();
            ProduitViande produitViande = (ProduitViande) constructeur.newInstance ();
            produitViande.valider();
            if (produitViande.isCertifier()) return produitViande;
        }
        catch (InstantiationException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    private ProduitViande produitProduitSpe(String type, String[] args, Object... arguments) {
        try{
            Class<?> classe = Class.forName("fr.univamu.iut.ProduitFermier.ProduitViande."+type);
            // Récupération du constructeur prenant en paramètre une chaîne de caractères
            Constructor constructors[] = classe.getConstructors();
            for (Constructor constructor : constructors)
            {
                if ((Boolean) isRightConstructor(constructor,args)) {
                    ProduitViande produitViande = (ProduitViande) constructor.newInstance (arguments);
                    produitViande.valider();
                    if (produitViande.isCertifier()) return produitViande;
                }
            }

        }
        catch (InstantiationException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ProduitFermier produitProduit(String type) {
        return produitProduitSpe(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {
        return produitProduitSpe(type, args, arguments);
    }
}
