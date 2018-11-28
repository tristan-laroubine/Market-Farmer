package fr.univamu.iut.exo4;


import fr.univamu.iut.exo1.Color;

public class Cafetiere implements Connectable {
    @Override
    public void equiper(String gadget) {
        System.out.println("On ´equipe la cafetiere avec " + gadget);
    }

    @Override
    public void demarrer() {
        System.out.println("Cafetiere ON");
    }

    @Override
    public String toString() {
        return Color.ANSI_GREEN + "Cafetiere";
    }
}
