package fr.univamu.iut.exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppliDomotique {
    static ArrayList<Connectable> objets = new ArrayList<Connectable>();

    public static int menu() {
        int choix = 1;
        System.out.println("Taper 0 pour finir, 1 pour connecter une cafetière et 2 pour une radio");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static void connecter(int type) {
        switch (type) {
            case 1:
                Radio objetTemp = new Radio();
                objetTemp.equiper("le gadget");
                objets.add(objetTemp);
                break;
            case 2:

                Cafetiere objetTemp2 = new Cafetiere();
                objetTemp2.equiper("le gadget");
                objets.add(objetTemp2);
                break;
        }
    }

    public static void main(String[] args) {
        int type = 0;
        while ((type = menu()) != 0) {
            connecter(type);
        }
        System.out.println(objets);
    }
}
