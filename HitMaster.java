public class HitMaster implements EngravingMultiplier {
    final double MULTIPLIER = 0.16;
    public HitMaster() {
    }

    public void update(Spell spell, int engravingNumber) {
        engravingMultiplier(spell, engravingNumber);
    }

    public void engravingMultiplier(Spell spell, int engravingNumber) {
        spell.engravingSetMulti(engravingNumber, MULTIPLIER);
        System.out.println("--- HIT MASTER SET --- " + MULTIPLIER + " multi, Engraving Number: " + engravingNumber);
    }
}
