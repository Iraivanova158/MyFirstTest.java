import org.junit.jupiter.api.Test;

public class CountTotalAmount<c> {
    @Test
    public void firstTask () {
        System.out.println("First amount (eur)");
        System.out.println(object(20000));
        System.out.println("Interest 3% for 5 years (eur)");
        System.out.println(countTwoDigits(20000.00,0.15));
        System.out.println("Total amount to pay (eur)");
        System.out.println(sumTwoDigits(20000, 3000));
    }
    private int object (int a){

        return a;
    }
    private double countTwoDigits (double a, double b){
        double c = a * b;
        return c;
    }
    private int sumTwoDigits (int a, int b){
        int c = a + b;
        return c;
    }
}
