import java.util.*;

public class Odejmowanie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczby dla pierwszego zbioru oddzielone spacją: ");
        String inputA = scanner.nextLine();

        System.out.print("Podaj liczby dla drugiego zbioru oddzielone spacją: ");
        String inputB = scanner.nextLine();

        String[] numbersA = inputA.split(" ");
        String[] numbersB = inputB.split(" ");

        // Utwórz zbiory i dodaj do nich liczby
        Set<Integer> setA = new HashSet<>();
        for (String number : numbersA) {
            setA.add(Integer.parseInt(number));
        }

        Set<Integer> setB = new HashSet<>();
        for (String number : numbersB) {
            setB.add(Integer.parseInt(number));
        }

        //(A - B) ∩ (B - A)
        Set<Integer> result = new HashSet<>();
        for (int number : setA) {
            if (!setB.contains(number)) {
                result.add(number);
            }
        }
        for (int number : setB) {
            if (!setA.contains(number)) {
                result.add(number);
            }
        }

        System.out.print("Wynik: [");
        for (int number : result) {
            System.out.print(number + " ");
        }
        System.out.println("]");
        scanner.close();
    }
}
