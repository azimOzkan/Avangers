package Avengers;

public class Ironman extends Avenger
{
    public Ironman(){
        Name = "Iron Man";
        Agility = 40;
        Strength =70;
        Health = 120;
        Ultibar = 5;
    }
    public Ironman(String playerName){
        Name = "Iron Man (" + playerName +")";
        Agility = 40;
        Strength =70;
        Health = 120;
        Ultibar = 5;
    }
}
