import java.util.Comparator;

class Hamster implements Comparable<Hamster> {
    private int hamsterNumber;
    private String name;

    Hamster(int i) {
        hamsterNumber = i;
    }

    public String getHamsterNumber() {
        return "To jest chomik #" + hamsterNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hamster other) {
        return this.name.compareTo(other.name);
    }
}
