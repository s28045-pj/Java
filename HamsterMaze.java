import java.util.*;

public class HamsterMaze {
    public static void main(String[] args) {
        List<Hamster> hamsterList = new ArrayList<>();
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
                hamsterList.add(hamster);
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowe dane.");
                scanner.nextLine();
                i--;
            }
        }

        Printer.printAll(hamsterList);
        removeHamster(hamsterList);
        Collections.sort(hamsterList);
        Printer.printAll(hamsterList);
    }

    private static void removeHamster(List<Hamster> hamsterList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imie chomika do usuniecia: ");
        String hamsterName = scanner.nextLine();

        Iterator<Hamster> iterator = hamsterList.iterator();
        while (iterator.hasNext()) {
            Hamster hamster = iterator.next();
            if (hamster.getName().equals(hamsterName)) {
                iterator.remove();
                System.out.println("Chomik usuniety.");
                return;
            }
        }

        System.out.println("Nie znaleziono chomika.");
    }
}
