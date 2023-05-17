package Avengers;

public class Blackwidow extends Avenger
{
    public Blackwidow(){
        Name = "Black Widow";
        Agility = 50;
        Strength =60;
        Health = 100;
        Ultibar = 8;
    }
    public Blackwidow(String playerName){
        Name = "Black Widow (" + playerName +")";
        Agility = 50;
        Strength =60;
        Health = 100;
        Ultibar = 8;
    }
}
