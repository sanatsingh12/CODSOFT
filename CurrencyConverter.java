
import java.util.Scanner;

class CurrencyConverter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Currency Converter ---");
        System.out.println("Available currencies: 1. USD  2. EUR  3. INR");
        System.out.print("Enter base currency (USD/EUR/INR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency (USD/EUR/INR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        double rate = getRate(base, target);
        if (rate == -1) {
            System.out.println("Conversion not available!");
        } else {
            double result = amount * rate;
            System.out.println(amount + " " + base + " = " + result + " " + target);
        }
        sc.close();
    }

    // simple conversion rates (static)
    public static double getRate(String base, String target) {
        if (base.equals("USD") && target.equals("INR")) return 83.0;
        if (base.equals("INR") && target.equals("USD")) return 0.012;
        if (base.equals("EUR") && target.equals("INR")) return 90.0;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;
        if (base.equals("USD") && target.equals("EUR")) return 0.93;
        if (base.equals("EUR") && target.equals("USD")) return 1.07;
        if (base.equals(target)) return 1.0; // same currency
        return -1; // not available
    }
}
