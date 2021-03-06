package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Classe UniteDeProduction
 */
public abstract class UniteDeProduction {

    /**
     * Fonction permettant de produire un produit selon le type passé en paramètre
     * @param type
     * @return produitFermier
     */
    public ProduitFermier produitProduit(String type){
        try{
            Class<?> classe = Class.forName(type);
            java.lang.reflect.Constructor constructeur = classe.getConstructor ();
            ProduitFermier produitFermier = (ProduitFermier) constructeur.newInstance ();
            if (produitFermier.valider()) return produitFermier;
        }
        catch (InstantiationException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * permet de produire un produit selon un type et les arguments
     * @param type
     * @param args
     * @param arguments
     * @return produitFermier
     */
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments){
        try{

            Class<?> classe = Class.forName(type);
            // Récupération du constructeur prenant en paramètre une chaîne de caractères
            Constructor constructors[] = classe.getConstructors();
            for (Constructor constructor : constructors)
            {
                if ((Boolean) isRightConstructor(constructor,args)) {
                    ProduitFermier produitFermier = (ProduitFermier) constructor.newInstance (arguments);
                    if (produitFermier.valider()) return produitFermier;
                }
            }
        }
        catch (InstantiationException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Permet de verifier si le constructeur est le bon par rapport aux arguments
     * @param constructor
     * @param args
     * @return boolean
     */
    boolean isRightConstructor(Constructor constructor, String[] args){
        Class[] params = constructor.getParameterTypes();
        if (params.length != args.length) return false;
        for (int i = 0; i < params.length; i++) {
            try {
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
