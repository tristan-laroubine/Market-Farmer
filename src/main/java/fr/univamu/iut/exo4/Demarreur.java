package fr.univamu.iut.exo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Demarreur {
    public Collection<Connectable> getObjets() {
        return objets;
    }

    Collection<Connectable> objets = new ArrayList<>();
    void demarrerLesActivés()
    {
        for (Connectable objet: objets
             ) {
            objet.demarrer();
        }
    }
    void attacher(Connectable objet){
        objets.add(objet);
    }
    void detacher(Connectable objet){
        objets.remove(objet);
    }

}
