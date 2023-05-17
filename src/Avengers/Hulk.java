package Avengers;
import Avengers.Avenger;

public class Hulk extends Avenger
{
    public Hulk(){
        Name = "Hulk";
        Agility = 10;
        Strength =100;
        Health = 200;
        Ultibar = 2;
    }
    public Hulk(String playerName){
        Name = "Hulk (" + playerName +")";
        Agility = 10;
        Strength =100;
        Health = 200;
        Ultibar = 2;
    }

}
