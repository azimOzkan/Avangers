package Avengers;
import java.util.concurrent.ThreadLocalRandom;
public abstract class Avenger
{
    protected String Name;
    protected int Strength;
    protected int Agility;
    protected int Health;
    protected int Ultibar;

    public String GetName() { return this.Name; }
    public int GetStrength() { return this.Strength; }
    public int GetAgility() { return this.Agility; }
    public int GetHealth() { return this.Health; }
    public int GetUltibar() { return this.Ultibar; }

    public <T extends Avenger>void Attack(T to)
    {
        int damage = 0;

        if (Ultibar>=10) {
            damage = generateDamage(to.Agility,true);
            SetUltibartoZero();
            System.out.println(this.Name + " Used his Ulti and generate " + damage + " damage to " + to.GetName());
        }
        else {
            damage = generateDamage(to.Agility,false);
            System.out.println(this.Name + " Attacked and generate " + damage + " damage to " + to.GetName());
        }

        to.SetHealtDown(damage);
    }
    public void Defense() {
        int he = ThreadLocalRandom.current().nextInt(20, 200);
        int ag = ThreadLocalRandom.current().nextInt(5,50);
        SetHealtUp(he);
        SetAgilityUp(ag);

        System.out.println(this.Name + " Made defense and increase his Healt by " + he +" and Agility by " + ag);
    }
    protected void SetAgilityUp(int val) {
        this.Agility+= val;
        if (this.Agility > 50) this.Agility=50;
    }
    protected void SetHealtUp(int val) {
        this.Health+= val;
        if (this.Health > 200) this.Health=200;
    }
    protected void SetHealtDown(int val) {
        this.Health-=val;
        if (this.Health < 0) this.Health=0;
    }
    protected void SetUltibartoZero() {
        this.Ultibar = 0;
    }

    private int generateDamage(int toAgility,boolean ulti) {
        int strength = this.Strength;
        if (ulti) {
            strength*=2;
            toAgility /=2;
        }
        int damage = ThreadLocalRandom.current().nextInt(0, strength+1);
        int defense = ThreadLocalRandom.current().nextInt(0, toAgility+1);
        defense /=2;

        int realDamage = damage-defense;

        if (damage>defense) {
            this.Ultibar += ThreadLocalRandom.current().nextInt(1,3);
            this.SetHealtUp(realDamage/2);
            return realDamage;
        }
        else return 0;
    }

}
