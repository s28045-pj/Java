import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź ciąg znaków:");
        String input = scanner.nextLine();

        // Usuwanie znaków specjalnych i konwertowanie na małe litery
        input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Tworzenie słownika
        Map<String, Integer> wordCountMap = new TreeMap<>();

        // Podział ciągu znaków na słowa
        String[] words = input.split(" ");

        // Liczenie wystąpień słów
        for (String word : words) {
            if (!word.isEmpty()) {
                int count = wordCountMap.getOrDefault(word, 0);
                wordCountMap.put(word, count + 1);
            }
        }

        // Wyświetlanie wyników
        System.out.println("Wynik:");
        System.out.println(wordCountMap);
    }
}
