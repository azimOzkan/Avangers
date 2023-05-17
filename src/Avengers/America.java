package Avengers;
import Avengers.Avenger;

public class America extends Avenger
{
    public America(){
        Name = "Captain America";
        Agility = 40;
        Strength =60;
        Health = 150;
        Ultibar = 3;
    }
    public America(String playerName){
        Name = "Captain America (" + playerName +")";
        Agility = 40;
        Strength =60;
        Health = 150;
        Ultibar = 3;
    }
}
