public class Grudge implements EngravingMultiplier {
    final double MULTIPLIER = 0.16;
    public Grudge() {
    }

    public void update(Spell spell, int engravingNumber) {
        engravingMultiplier(spell, engravingNumber);
    }

    public void engravingMultiplier(Spell spell, int engravingNumber) {
        spell.engravingSetMulti(engravingNumber, MULTIPLIER);
        System.out.println("--- GRUDGE SET --- " + MULTIPLIER + " multi, Engraving Number: " + engravingNumber);
    }
}
