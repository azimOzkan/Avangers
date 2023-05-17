import Avengers.*;

import java.util.Scanner;

public class GameEngine
{
    Avenger player1,player2;
    int turn = 1;
    public void Start() {
        while(true) {
            drawMenu();
            getInputs();
            startGame();

            //Play Again
            Scanner keyboard= new Scanner(System.in);
            String selection = "";
            while(true) {
                System.out.print("Do you want to play again ? (Y/N) : ");
                try {
                    selection = keyboard.next();
                    selection = selection.toUpperCase();
                    if (selection.equals("Y") || selection.equals("N")) break;
                    throw new Exception("");
                }
                catch(Exception exp) {
                    System.out.println("Please Make a Valid Choice");
                }
            }

            if (selection.equals("N")) break; // finish game
        }

    }

    private void startGame() {
        while(true) {
            if (player1.GetHealth()<=0 && player2.GetHealth()<=0) {
                System.out.println("GAME OVER THIS IS A DRAW");
                break;
            }
            else {
                if (player2.GetHealth() <= 0) {
                    System.out.println(player1.GetName() + " WINS   CONGRATULATIONS");
                    break;
                }
                if (player1.GetHealth() <= 0) {
                    System.out.println(player2.GetName() + " WINS   CONGRATULATIONS");
                    break;
                }
            }

            drawHealths();
            playOneTurn();
        }
    }

    private void playOneTurn() {
        String selection;
        if (turn==1) {
            Scanner keyboard= new Scanner(System.in);
            while(true) {
                System.out.print("("+player1.GetName()+") Choose your action Attack (A), Defense (D) :");
                try {
                    selection = keyboard.next();
                    selection = selection.toUpperCase();
                    if (selection.equals("A") || selection.equals("D")) break;
                    throw new Exception("");
                }
                catch(Exception exp) {
                    System.out.println("Please Make a Valid Choice");
                }
            }
            if (selection.equals("A")) player1.Attack(player2);
            if (selection.equals("D")) player1.Defense();
            turn=2;
            return;
        }
        if (turn==2) {
            Scanner keyboard= new Scanner(System.in);
            while(true) {
                System.out.print("("+player2.GetName()+") Choose your action Attack (A), Defense (D) :");
                try {
                    selection = keyboard.next();
                    selection = selection.toUpperCase();
                    if (selection.equals("A") || selection.equals("D")) break;
                    throw new Exception("");
                }
                catch(Exception exp) {
                    System.out.println("Please Make a Valid Choice");
                }
            }
            if (selection.equals("A")) player2.Attack(player1);
            if (selection.equals("D")) player2.Defense();
            turn=1;
            return;
        }
    }
    private void drawHealths() {
        String p1h = "";
        String p2h = "";
        String p1Ulti = "";
        String p2Ulti = "";
        for(int i=1; i<=player1.GetHealth()/3; i++) p1h+="*";
        for(int i=1; i<=player2.GetHealth()/3; i++) p2h+="*";
        for(int i=1; i<=player1.GetUltibar(); i++) p1Ulti+="*";
        for(int i=1; i<=player2.GetUltibar(); i++) p2Ulti+="*";
        p1h += " ("+ player1.GetHealth() +")";
        p2h += " ("+ player2.GetHealth() +")";
        System.out.printf("%-75s %s\n", player1.GetName(), player2.GetName());
        System.out.printf("%-75s %s\n", p1h, p2h);
        System.out.printf("%-10s %-64s %-10s %s\n", p1Ulti, "("+player1.GetUltibar()+" Ulti)", p2Ulti, "("+player2.GetUltibar()+" Ulti)");
    }
    private void getInputs() {
        Scanner keyboard= new Scanner(System.in);
        while(true) {
            System.out.print("Choose Your Avenger (Player 1) :");
            try {
                String selection = keyboard.next();
                if (Integer.parseInt(selection) <1 || Integer.parseInt(selection)>5) throw new Exception("");
                player1 = selectAvenger(Integer.parseInt(selection));
                break;
            }
            catch(Exception exp) {
                System.out.println("Please Make a Valid Choice");
            }
        }

        while(true) {
            System.out.print("Choose Your Avenger (Player 2) :");
            try {
                String selection = keyboard.next();
                if (Integer.parseInt(selection)<1 || Integer.parseInt(selection)>5) throw new Exception("");
                player2 = selectAvenger(Integer.parseInt(selection));
                break;
            }
            catch(Exception exp) {
                System.out.println("Please Make a Valid Choice");
            }
        }
    }
    private Avenger selectAvenger(int selection) {
        if (selection == 1) return new Hulk();
        if (selection == 2) return new America();
        if (selection == 3) return new Ironman();
        if (selection == 4) return new Thor();
        if (selection == 5) return new Blackwidow();
        return null;
    }
    private void drawMenu() {
        System.out.println("--WELCOME TO AVENGERS GAME OF WAR--");
        drawPropertyToScreen(new Hulk(),1);
        drawPropertyToScreen(new America(),2);
        drawPropertyToScreen(new Ironman(),3);
        drawPropertyToScreen(new Thor(),4);
        drawPropertyToScreen(new Blackwidow(),5);
    }
    private void drawPropertyToScreen(Avenger avenger, int number)
    {
        int health = avenger.GetHealth() / 10;
        int strength = (avenger.GetStrength() /10)*2;
        int agility = (avenger.GetAgility() /10)*4;

        System.out.println(number + " ---------- "+avenger.GetName()+" ---------- ");

        System.out.print("    Health : ");
        for (int i=1; i<=health; i++) System.out.print("*");
        System.out.println("");
        System.out.print("  Strength : ");
        for (int i=1; i<=strength; i++) System.out.print("*");
        System.out.println("");
        System.out.print("   Agility : ");
        for (int i=1; i<=agility; i++) System.out.print("*");
        System.out.println("");
    }
}
