import java.util.*;

class Hamster {
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
}

class Printer {
    static void printAll(List<Hamster> hl) {
        for (Hamster hamster : hl) {
            System.out.println(hamster.getHamsterNumber() + " o imieniu: " + hamster.getName());
        }
    }
}

class HamsterMaze {
    public static void main(String[] args) {
        Map<String, Hamster> hamsterMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Podaj numer chomika: ");
                int hamsterNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Podaj imie chomika: ");
                String hamsterName = scanner.nextLine();

                if (hamsterNumber < 0 || !hamsterName.matches("[a-zA-Z]+")) {
                    System.out.println("Nieprawidlowe dane.");
                    i--;
                    continue;
                }

                Hamster hamster = new Hamster(hamsterNumber);
                hamster.setName(hamsterName);
                hamsterMap.put(hamsterName, hamster);
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowe dane.");
                scanner.nextLine();
                i--;
            }
        }

        Printer.printAll(new ArrayList<>(hamsterMap.values()));
    }
}
