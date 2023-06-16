public class MyDate {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Nieprawidłowy miesiąc");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Nieprawidłowy dzień");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1990 && year <= 2050) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Nieprawidłowy rok");
        }
    }

    public void displayDate() {
        String formattedMonth = String.format("%02d", month);
        String formattedDay = String.format("%02d", day);
        System.out.println(formattedDay + "/" + formattedMonth + "/" + year);
    }
}
