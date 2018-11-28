package fr.univamu.iut.exo2;

import fr.univamu.iut.exo1.Connectable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.M;

public class AppliDomotique {
    public static void main(String[] args) {
        ArrayList<fr.univamu.iut.exo1.Connectable> objets = new ArrayList<Connectable>();
        while (true){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot :");
        String str = sc.nextLine();
        if (str.isEmpty()) { break; }
        Fabrique fabrique = new FabriqueAmazon();
            try {
                fabrique.fabriquer(str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Type non reconnue");
                break;
            }
        }

    }
}
