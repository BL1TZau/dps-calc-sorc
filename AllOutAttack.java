public class AllOutAttack implements EngravingMultiplier {
    final double MULTIPLIER = 0.2;
    public AllOutAttack() {
    }

    public void update(Spell spell, int engravingNumber) {
        engravingMultiplier(spell, engravingNumber);
    }

    public void engravingMultiplier(Spell spell, int engravingNumber) {
        spell.engravingSetMulti(engravingNumber, MULTIPLIER);
        System.out.println("--- ALL OUT ATTACK SET --- " + MULTIPLIER + " multi, Engraving Number: " + engravingNumber);
    }
}
