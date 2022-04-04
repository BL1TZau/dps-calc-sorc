import java.lang.Math;

public abstract class Spell {
    protected double averageDamage;
    protected double critRate;
    protected double critDamage;
    protected double engravingAdd = 1;
    protected double engravingMulti1 = 1;
    protected double engravingMulti2 = 1;
    protected double engravingMulti3 = 1;
    protected String name;

    public Spell(String name, double averageDamage, double critRate, double critDamage) {
        this.name = name;
        this.averageDamage = averageDamage;
        this.critRate = critRate;
        this.critDamage = critDamage;

    }

    // dps calc
    public void dpsCalc(double loopControl) {
        int i = 0;
        double total = 0;
        double ans;
        double critCounter = 0;
        double nonCritCounter = 0;

        while (i < loopControl) {
            double a = Math.random() * 100;
            if (a > critRate) { // DON'T CRIT
                total += ((averageDamage * engravingAdd) * engravingMulti1 * engravingMulti2 * engravingMulti3);
                nonCritCounter += 1;
            } else if (a <= critRate) { // CRIT
                total += (averageDamage * engravingAdd * critDamage) * engravingMulti1 * engravingMulti2 * engravingMulti3;
                critCounter += 1;
            }
            i++;
        }
        ans = total / loopControl; // average

        System.out.println(name + ": " + ans + ", critRate: " + critRate + ", critDamage: " +
                critDamage + ", engravingAdd: " + engravingAdd+ ", engravingMulti1: " + engravingMulti1
                + ", engravingMulti2: " + engravingMulti2 + ", engravingMulti3: " + engravingMulti3);
        System.out.println("-- NonCrit Counter: " + nonCritCounter);
        System.out.println("-- Crit Counter: " + critCounter);

    }

    // Engravings - multi
    public void engravingSetMulti(int engravingNumber, double multiplier) {
        if (engravingNumber == 1) {
            this.engravingMulti1 += multiplier;
        } else if (engravingNumber == 2) {
            this.engravingMulti2 += multiplier;
        } else if (engravingNumber == 3) {
            this.engravingMulti3 += multiplier;
        }
    }

    // Engravings - additive
    public void engravingSetAdditive(double add) {
        this.engravingAdd += add;
    }

    // Engravings - crit chance
    public void engravingSetCritRate(double critRate) {
        this.critRate += critRate;
    }

    // Engravings - crit dmg
    public void engravingSetCritDamage(double critDamage) {
        this.critDamage += critDamage;
    }

    // getters
    public double getAverageDamage() {
        return averageDamage;
    }

    // setters
    public void setAverageDamage(double averageDamage) {
        this.averageDamage = averageDamage;
    }

    // toString
    public String toString() {
        return "The average damage is: " + averageDamage;
    }

}
