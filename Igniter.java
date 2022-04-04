public class Igniter implements EngravingCritRate, EngravingCritDamage {
    final double CRITDMG = 0.5;
    final double CRITRATE = 25;

    public Igniter() {
    }

    public void update(Spell spell) {
        engravingCritRate(spell);
        engravingCritDamage(spell);
    }
    @Override
    public void engravingCritRate(Spell spell) {
        spell.engravingSetCritRate(CRITRATE);
        System.out.println("--- IGNITER CRIT RATE SET --- +" + CRITRATE);
    }

    @Override
    public void engravingCritDamage(Spell spell) {
        spell.engravingSetCritDamage(CRITDMG);
        System.out.println("--- IGNITER CRIT DMG SET --- +" + CRITDMG);
    }
}
