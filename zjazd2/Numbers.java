public class Numbers {
    private int number1;
    private int number2;
    private int number3;

    public Numbers(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public int sum() {
        return number1 + number2 + number3;
    }

    public double average() {
        return (double) sum() / 3;
    }

    public int min() {
        return Math.min(Math.min(number1, number2), number3);
    }

    public int max() {
        return Math.max(Math.max(number1, number2), number3);
    }

    public double geometric() {
        return Math.cbrt(number1 * number2 * number3);
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers(4, 12, 20);

        System.out.println("Sum: " + numbers.sum());
        System.out.println("Average: " + numbers.average());
        System.out.println("Min: " + numbers.min());
        System.out.println("Max: " + numbers.max());
        System.out.println("Geometric: " + numbers.geometric());
    }
}
