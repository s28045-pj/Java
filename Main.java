import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj Świecie!");
        zadanie_01();
        zadanie_02();
        zadanie_03();
    }
    public static void zadanie_01 () {
        System.out.println("zadanie_01");
        {
            int a,b,c;
            Scanner input = new Scanner(System.in);
           System.out.println("Podaj wymiary pierwszego boku");
           a = input.nextInt();
           System.out.println("Podaj wymiary drugiego boku");
           b = input.nextInt();
           c=a*b;
           System.out.println("Wynik");
           System.out.println(c);
        }
    }
    public static void zadanie_02 (){
        System.out.println("zadanie_02");
        {
           double a,b;
           a= Math.PI;
           b = Math.sqrt(a);
            System.out.println(String.format("%.2f", b));
      }
    }
    public static void zadanie_03(){
        Scanner input = new Scanner(System.in);
        String napis1,napis2;
        System.out.println("Podaj piersze zdanie");
        napis1 = input.nextLine();
        System.out.println("Podaj drugie zdanie");
        napis2 = input.nextLine();
        System.out.println("%"  +napis1+ " " +napis2+ "%");

    }

}
