package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.lang.reflect.Constructor;

abstract class UniteDeProduction {
    abstract public ProduitFermier produitProduit(String type);
    abstract public ProduitFermier produitProduit(String type, String[] args, Object... arguments);

    boolean isRightConstructor(Constructor constructor, String[] args){
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
