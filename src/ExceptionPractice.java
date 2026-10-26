public class ExceptionPractice {
    public static void main(String[] args) {
        int number = 10;
        int divisor = 0;

        try {
            int result = number / divisor;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program continues.");
    }
}