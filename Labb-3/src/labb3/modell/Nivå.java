package labb3.modell;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Observable;

public class Nivå extends Observable {
    private Rum numRum;
    private ArrayList<Rum> usrRum;

    public Nivå(Rum startrum, ArrayList<Rum> rum) {
        this.numRum = startrum;
        this.usrRum = rum;

        if (!rum.contains(startrum)){
            throw new InputMismatchException();
        }

        for(int j = 0; j < usrRum.size(); j++){
            Rectangle rec = new Rectangle(usrRum.get(j).getPunkt().x(), usrRum.get(j).getPunkt().y(), usrRum.get(j).getBredd(), usrRum.get(j).getHöjd());
            for(int i = j; i < usrRum.size(); i++){
               Rectangle rec2 = new Rectangle(usrRum.get(i).getPunkt().x(), usrRum.get(i).getPunkt().y(), usrRum.get(i).getBredd(), usrRum.get(i).getHöjd());
               if(rec.intersects(rec2)){
                   throw new IllegalArgumentException();
               }
           }

        }
    }

    // instansmetod som returnerar alla rummen
    public ArrayList<Rum> roomNum(){
        return usrRum;
    }
    // Getter för numRum
    public Rum curRoom(){
        return this.numRum;
    }

    // Denna kollar om en väg har målats till eller från nuvarande rummet
    // Detta för att veta om man kan flytta till de nya rummet.
    public void hoppaÅt(Väderstreck väderstreck) {
        if(curRoom().finnsUtgångÅt(väderstreck)){
            if(numRum == numRum.gångenÅt(väderstreck).getRumFrån()){
                numRum = numRum.gångenÅt(väderstreck).getRumTill();
            }else {
                numRum = numRum.gångenÅt(väderstreck).getRumFrån();
            }
            setChanged();
            notifyObservers();
        }
    }
}
