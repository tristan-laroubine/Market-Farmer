package fr.univamu.iut.traitement.Acteur;

public interface StrategyCom {
    default double comissionMarchePourcentage(double benefice){
        return benefice*0.10;
    }
}
