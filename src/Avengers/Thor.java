package Avengers;

public class Thor extends Avenger
{
    public Thor(){
        Name = "Thor";
        Agility = 30;
        Strength =90;
        Health = 140;
        Ultibar = 4;
    }
    public Thor(String playerName){
        Name = "Thor (" + playerName +")";
        Agility = 30;
        Strength =90;
        Health = 140;
        Ultibar = 4;
    }

}
