package fr.univamu.iut.exo1;

public class Radio implements Connectable {
    @Override
    public void equiper(String gadget) {
        System.out.println("On ´equipe la radio avec " + gadget);
    }
}
