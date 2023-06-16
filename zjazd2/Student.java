public class Student {
    private String imie;
    private String nazwisko;
    private int numerIndeksu;
    private double obecnosc;
    private int ocenaPOJ;

    public Student(String imie, String nazwisko, int numerIndeksu, double obecnosc, int ocenaPOJ) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerIndeksu = numerIndeksu;
        this.obecnosc = obecnosc;
        this.ocenaPOJ = ocenaPOJ;
    }

    public Student(int numerIndeksu, double obecnosc, int ocenaPOJ) {
        this.imie = "Nieznane";
        this.nazwisko = "Nieznane";
        this.numerIndeksu = numerIndeksu;
        this.obecnosc = obecnosc;
        this.ocenaPOJ = ocenaPOJ;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(int numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public double getObecnosc() {
        return obecnosc;
    }

    public void setObecnosc(double obecnosc) {
        this.obecnosc = obecnosc;
    }

    public int getOcenaPOJ() {
        if (obecnosc < 50) {
            return 2;
        } else {
            return ocenaPOJ;
        }
    }

    public void setOcenaPOJ(int ocenaPOJ) {
        this.ocenaPOJ = ocenaPOJ;
    }
}
