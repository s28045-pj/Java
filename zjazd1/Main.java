import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj Świecie!");
        zadanie_01();
        zadanie_02();
        zadanie_03();
        zadanie_04();
        zadanie_05();
        zadanie_06();
        zadanie_09();
        zadanie_12();

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
            System.out.printf("%.2f%n", b);
        }
    }
    public static void zadanie_03(){
        System.out.println("zadanie_03");
        {
            Scanner input = new Scanner(System.in);
            String napis1, napis2;
            System.out.println("Podaj piersze zdanie");
            napis1 = input.nextLine();
            System.out.println("Podaj drugie zdanie");
            napis2 = input.nextLine();
            System.out.println("%" + napis2 + " " + napis1 + "%");
        }
    }
    public static void zadanie_04(){
        System.out.println("zadanie_04");
        {
            int a,b,c;
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj wymiary trójkąta");
            a = input.nextInt(); b = input.nextInt(); c = input.nextInt();
            if ((a<0)&&(b<0)&&(c<0)){
                System.out.println("Błąd");
            }if ((a+b>c)&&(a+c>b)&&(b+c>a)) System.out.println("Tak");
        else System.out.println("Nie");
        }
    }
    public static void zadanie_05(){
        System.out.println("zadanie_05");
        {
            int msc;
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj liczbę");
            msc= input.nextInt();
            if (msc >= 13) System.out.println("Błąd");
            switch (msc){
                case 1: System.out.println("Styczeń: 31 dni"); break;
                case 2: System.out.println("Luty: 28 dni"); break;
                case 3: System.out.println("Marzec: 31 dni"); break;
                case 4: System.out.println("Kwiecień: 30 dni"); break;
                case 5: System.out.println("Maj: 31 dni"); break;
                case 6: System.out.println("Czerwiec: 30 dni"); break;
                case 7: System.out.println("Lipiec: 31 dni"); break;
                case 8: System.out.println("Sierpień: 31 dni"); break;
                case 9: System.out.println("Wrzesień: 30 dni"); break;
                case 10: System.out.println("Październik: 31 dni"); break;
                case 11: System.out.println("Listopad: 30 dni"); break;
                case 12: System.out.println("Grudzień: 31 dni"); break;
            }
        }
    }
    public static void zadanie_06() {
        System.out.println("zadanie_06");
        {
            int a, b, c;
            System.out.println("Podaj 3 liczby");
            Scanner input = new Scanner(System.in);
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            if (a < b) {
            if (b < c)
                if (a < c)
                    System.out.println(a + " " + b + " " + c);
                    System.out.println(c + " " + b + " " + a);

            }
            else if (a < b) {
                if (b > c)
                    if (a < c)
                        System.out.println(a + " " + c + " " + b);
                        System.out.println(b + " " + c + " " + a);

            }
            else if (a > b) {
                if (b < c)
                    if (a < c)
                        System.out.println(b + " " + a + " " + c);
                        System.out.println(c + " " + a + " " + b);

            }
            else if (a < b) {
                if (b < c)
                    if (a > c)
                        System.out.println(c + " " + a + " " + b);
                        System.out.println(b + " " + a + " " + c);

            }
            else if (a > b) {
                if (b < c)
                    if (a > c)
                        System.out.println(b + " " + c + " " + a);
                        System.out.println(a + " " + c + " " + b);

            }
            else if (a > b) {
                if (b > c)
                    if (a > c)
                        System.out.println(c + " " + b + " " + a);
                        System.out.println(a + " " + b + " " + c);

            }
        }
    }
    public static void zadanie_09() {
        System.out.println("zadanie_09");
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj 1 wyraz: ");
            String a = input.nextLine();
            int e = a.length();

            int ff = 0;
            int f = (e - 1);
            for (int i = 0; i < e; i++) {

                if (a.charAt(i) != a.charAt(f)) {
                    ff = 1;
                    break;
                }
                f--;
            }
            if (ff == 1)
                System.out.println("Nie jest palindromem");
            else {
                System.out.println("Jest palindromem");
            }
        }
    }
    public static void zadanie_12() {
        System.out.println("zadanie_12");
        {
            double a,b,c;
            int planeta;
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj liczbę sekund");
            a = input.nextInt();
            System.out.println("Podaj liczbe planety");
            System.out.println("1-Merkury");
            System.out.println("2-Wenus");
            System.out.println("3-Ziemia");
            System.out.println("4-Mars");
            System.out.println("5-Jowisz");
            System.out.println("6-Saturn");
            System.out.println("7-Uran");
            System.out.println("8-Neptun");
            planeta = input.nextInt();
            b = a/31557600;
            switch(planeta){
                case 1:{
                    c=b/0.2408467;
                    System.out.printf("%.2f%n", c); break;
                }
                case 2:{
                    c=b/0.61519726;
                    System.out.printf("%.2f%n", c); break;
                }
                case 3:{
                    b=a/31557600;
                    System.out.printf("%.2f%n", b); break;
                }
                case 4:{
                    c=b/1.8808158;
                    System.out.printf("%.2f%n", c); break;
                }
                case 5:{
                    c=b/11.862615;
                    System.out.printf("%.2f%n", c); break;
                }
                case 6:{
                    c=b/29.447498;
                    System.out.printf("%.2f%n", c); break;
                }
                case 7:{
                    c=b/84.016846;
                    System.out.printf("%.2f%n", c); break;
                }
                case 8:{
                    c=b/164.79132;
                    System.out.printf("%.2f%n", c); break;
                }
            }
        }
    }
    public static void zadanie_13() {
        System.out.println("zadanie_13");
        {
            int[] tab = new int[5];
        }
    }
}
