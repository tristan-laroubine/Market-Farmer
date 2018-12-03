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

    public ProduitViande produitProduit(String type) {
        try{
            Class<?> classe = Class.forName("fr.univamu.iut.ProduitFermier.ProduitViande."+type);
            // Récupération du constructeur prenant en paramètre une chaîne de caractères
            java.lang.reflect.Constructor constructeur =
                    classe.getConstructor (new Class [] {});
            constructeur.newInstance (new Object [] {});
            return (ProduitViande) constructeur.newInstance (new Object [] {});
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ProduitViande produitProduit(String type, String[] args, Object... arguments) {
        try{
            Class<?> classe = Class.forName("fr.univamu.iut.ProduitFermier.ProduitViande."+type);
            // Récupération du constructeur prenant en paramètre une chaîne de caractères
            Constructor constructors[] =
                    classe.getConstructors();
            for (Constructor constructor : constructors)
            {
                if ((Boolean) isRightConstructor(constructor,args))
                    return (ProduitViande) constructor.newInstance (arguments);
            }

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean isRightConstructor(Constructor constructor, String[] args){
        Class[] params = constructor.getParameterTypes();
        if (params.length != args.length) return false;
        for (int i = 0; i < params.length; i++) {
            try {
                System.out.println("Parametre => " + params[i]);
                if (params[i] != Class.forName(args[i])) {
                    return false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
