public class Kapral extends Soldier {
    public static final int MILITARY_RANK = 2;

    public Kapral(double experience) {
        super(MILITARY_RANK, experience);
    }

    @Override
    public Soldier addExperience() {
        setExperience(getExperience() + 1);
        if (getExperience() == 5 * getMilitaryRankValue()) {
            return new Kapitan(1);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Kapral{ "  + super.toString();
    }
}
