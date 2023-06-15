public class Major extends Soldier {
    public static final int MILITARY_RANK = 4;

    public Major(double experience) {
        super(MILITARY_RANK, experience);
    }

    @Override
    public Soldier addExperience() {
        setExperience(getExperience() + 1);
        return this;
    }

    @Override
    public String toString() {
        return "Major{ " + super.toString();
    }
}
