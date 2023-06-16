public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Gosia", "Duda", 123456, 80, 4);
        Student student2 = new Student("Jacek", "Garnek", 654321, 30, 3);
        Student student3 = new Student(987654, 70, 5);

        System.out.println("Student 1: " + student1.getImie() + " " + student1.getNazwisko());
        System.out.println("Numer indeksu: " + student1.getNumerIndeksu());
        System.out.println("Obecność: " + student1.getObecnosc() + "%");
        System.out.println("Ocena z POJ: " + student1.getOcenaPOJ());

        System.out.println();

        System.out.println("Student 2: " + student2.getImie() + " " + student2.getNazwisko());
        System.out.println("Numer indeksu: " + student2.getNumerIndeksu());
        System.out.println("Obecność: " + student2.getObecnosc() + "%");
        System.out.println("Ocena z POJ: " + student2.getOcenaPOJ());

        System.out.println();

        System.out.println("Student 3: " + student3.getImie() + " " + student3.getNazwisko());
        System.out.println("Numer indeksu: " + student3.getNumerIndeksu());
        System.out.println("Obecność: " + student3.getObecnosc() + "%");
        System.out.println("Ocena z POJ: " + student3.getOcenaPOJ());
    }
}
