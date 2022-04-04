import java.util.Arrays;

public class MainTest {
    // helpers
    static final int EXCELROWS = 5; // variable for amount of rows in excel
    static private int loopControl = 10000;
    static double[] doomsdayArray = new double[EXCELROWS];
    static double[] explosionArray = new double[EXCELROWS];
    static ExcelReader excelReader = new ExcelReader(EXCELROWS);

    // engravings
    static private EngravingMultiplier allOutAttack;
    static private EngravingMultiplier grudge;
    static private EngravingMultiplier hitMaster;
    static private EngravingCritRate preciseDagger;
    static private Igniter igniter;

    // spells
    static private Spell spellExplosion;

    public static void main(String[] args) {
        setup();
        System.out.println(spellExplosion.toString());
        spellExplosion.dpsCalc(loopControl);

        // engrave 1
        igniter.update(spellExplosion);
        spellExplosion.dpsCalc(loopControl);

        // engrave 2
        allOutAttack.update(spellExplosion, 1);
        spellExplosion.dpsCalc(loopControl);

        // hello
        // is this a change

    }

    public static void tester() {

    }
    // all setup
    public static void setup() {
        initialiseExcelArray("Explosion", explosionArray);
        System.out.println(Arrays.toString(explosionArray));

        initialiseSpells();
        initialiseEngravings();
    }

    // initalise all spell objects
    public static void initialiseSpells() {
        spellExplosion = new Explosion("Explosion", spellAverage(explosionArray), 35, 2);
    }

    // initialise all engravings
    public static void initialiseEngravings() {
         allOutAttack = new AllOutAttack();
         grudge = new Grudge();
         hitMaster = new HitMaster();
//         preciseDagger = new PreciseDagger();
         igniter = new Igniter();
    }

    // Average spell damage based off array
    public static double spellAverage(double[] array) {
        int i;
        double total = 0;
        for (i = 0; i < EXCELROWS; i++) {
            total += array[i];
        }
        return total / EXCELROWS;
    }

    // Inputting data from excel to arrays
    public static void initialiseExcelArray(String name, double[] array) {
        int i;

        for (i = 0; i < excelReader.getAmountOfRows(); i++) {
            array[i] = excelReader.ExcelReader(i, 0, name);
        }
        System.out.println("-- " + name + " Array initialisation complete");
    }

    // Printing all arrays
    public static void finishedArrays() {
        System.out.println("Doomsday: " + Arrays.toString(doomsdayArray));
        System.out.println("Explosion: " + Arrays.toString(explosionArray));
    }
}
