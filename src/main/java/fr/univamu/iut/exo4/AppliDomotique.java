package fr.univamu.iut.exo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AppliDomotique {
    public static void main(String[] args) {
        Demarreur demarreur = new Demarreur();
        ArrayList<Connectable> collection = new ArrayList<>();
        collection.add(new Radiateur());
        collection.add(new Cafetiere());
        collection.add(new Radio());
        for (Connectable c: collection
             ) {
            System.out.println("Voulez attacher " + c +" ? (oui / non)");
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir une reponse :");
            String str = sc.nextLine();
            switch (str){
                case "oui":
                    demarreur.attacher(c);
                    break;
                case "non" :
                    break;
                default:
                    System.out.println("Réponse fausse  = non che !");
                    break;
            }
        }
        demarreur.demarrerLesActivés();
        updateActivés(demarreur);
        demarreur.demarrerLesActivés();
    }
    public static void updateActivés(Demarreur demarreur){
        ArrayList<Connectable> objets = (ArrayList<Connectable>) demarreur.getObjets();
        Iterator<Connectable> it = objets.iterator() ;
        while (it.hasNext())
        {
            Connectable objet = it.next();
            System.out.println("Voulez vous éteindre " + objet + "? ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir une reponse :");
            String str = sc.nextLine();
            switch (str){
                case "oui":
                    it.remove();
                    demarreur.detacher(objet);
                    break;
                case "non" :
                    break;
                default:
                    System.out.println("Réponse fausse  = non che !");
                    break;
            }
        }
    }

}
