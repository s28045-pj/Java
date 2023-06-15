import java.util.Objects;

public abstract class Soldier {
    //stopien wojskowy
    private int militaryRankValue;
    private double experience;

    public Soldier(int militaryRankValue, double experience) {
        this.militaryRankValue = militaryRankValue;
        this.experience = experience;
    }

    public abstract Soldier addExperience();

    public Soldier minusExperience() {
        experience -= 1;
        if (experience == 0) {
            return null;
        }
        return this;
    }

    public int getMilitaryRankValue() {
        return militaryRankValue;
    }

    public double getForce() {
        return militaryRankValue * experience;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "militaryRankValue=" + militaryRankValue +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return militaryRankValue == soldier.militaryRankValue && Double.compare(soldier.experience, experience) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(militaryRankValue, experience);
    }
}

