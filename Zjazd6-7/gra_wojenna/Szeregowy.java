public class Szeregowy extends Soldier {
    public static final int MILITARY_RANK = 1;

    public Szeregowy(double experience) {
        super(MILITARY_RANK, experience);
    }

    @Override
    public Soldier addExperience() {
        setExperience(getExperience() + 1);
        if (getExperience() == 5 * getMilitaryRankValue()) {
            return new Kapral(1);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Szeregowy{ " + super.toString();
    }
}
