package fr.univamu.iut.exo4;

public class Radio implements Connectable {
    @Override
    public void equiper(String gadget) {
        System.out.println("On ´equipe la radio avec " + gadget);
    }

    @Override
    public void demarrer() {
        System.out.println("Radio ON");
    }
    @Override
    public String toString() {
        return "Radio";
    }
}
