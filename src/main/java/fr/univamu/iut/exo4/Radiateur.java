package fr.univamu.iut.exo4;


public class Radiateur implements Connectable
{
    @Override
    public void equiper(String gadget) {
        System.out.println("On ´equipe le Radiateur avec " + gadget);
    }

    @Override
    public void demarrer() {
        System.out.println("Radiateur ON");
    }
    @Override
    public String toString() {
        return "Radiateur";
    }
}
