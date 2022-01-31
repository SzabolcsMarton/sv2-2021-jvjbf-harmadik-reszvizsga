package vehiclerental;

import java.time.LocalTime;

public interface Rentable extends Comparable<Rentable>{

    int calculateSumPrice(long minutes);
    LocalTime getRentingTime();
    void rent(LocalTime time);
    void closeRent();

    @Override
    default int compareTo(Rentable o){
        return this.getRentingTime().compareTo(o.getRentingTime());
    };

    //    melynek négy absztrakt metódusa a ,
//    a ,  és a .
//    Az interface terjessze ki a Comparable<Rentable> interface-t és a compareTo() metódust
//    úgy definiálja felül alapértelmezetten, hogy a természetes rendezés a bérlési idő
//    szerint legyen növekvő sorrendben.
}
