import java.util.*;

public class SortowanieLiczb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczby oddzielone spacją:");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        // Tworzymy zbiór, do którego dodamy podane liczby
        Set<Integer> numbers = new TreeSet<>();

        for (String part : parts) {
            try {
                // Parsujemy każdą część na liczbę i dodajemy do zbioru
                int number = Integer.parseInt(part);
                numbers.add(number);
            } catch (NumberFormatException e) {
            }
        }
        
        System.out.println("Dane wyjściowe: " + numbers);
    }
}
