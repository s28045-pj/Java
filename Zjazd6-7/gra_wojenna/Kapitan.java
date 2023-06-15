public class Kapitan extends Soldier {
    public static final int MILITARY_RANK = 3;

    public Kapitan(double experience) {
        super(MILITARY_RANK, experience);
    }

    @Override
    public Soldier addExperience() {
        setExperience(getExperience() + 1);
        if (getExperience() == 5 * getMilitaryRankValue()) {
            return new Major(1);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Kapitan{ " + super.toString();
    }
}
