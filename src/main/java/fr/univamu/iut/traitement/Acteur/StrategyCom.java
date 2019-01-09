package fr.univamu.iut.traitement.Acteur;

public interface StrategyCom {
    /**
     * renvoie le bénéfice aprés la prise des taxes
     * @param benefice correspond au prix qui doit être taxé
     * @return double
     */
    default double comissionMarchePourcentage(double benefice){
        return benefice*0.10;
    }
}
