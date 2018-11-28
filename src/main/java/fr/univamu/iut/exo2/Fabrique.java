package fr.univamu.iut.exo2;

import fr.univamu.iut.exo1.Cafetiere;
import fr.univamu.iut.exo1.Connectable;
import fr.univamu.iut.exo1.Radio;

public abstract class Fabrique {

        Connectable fabriquer(String type) throws ClassNotFoundException{
            switch (type){
                case "Radiateur" :
                    Radiateur temp = new Radiateur();
                    equiperSpe(temp);
                    return temp;

                case "Cafetiere" :
                    Cafetiere temp2 = new Cafetiere();
                    equiperSpe(temp2);
                    return temp2;
                case "Radio" :
                    Radio temp3 = new Radio();
                    equiperSpe(temp3);
                    return temp3;
                default :
                        throw new ClassNotFoundException();
            }
        }
    abstract void equiperSpe(Connectable connectable);


}
