import java.util.Scanner;

public class M04_TieredTaxSimple {
    public static int calculateTax(int income) {
        int tax = 0;

        if (income > 1000000) {
            tax += (income - 1000000) * 30 / 100;
            income = 1000000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 20 / 100;
            income = 500000;
        }
        if (income > 120000) {
            tax += (income - 120000) * 12 / 100;
            income = 120000;
        }
        tax += income * 5 / 100;

        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = scanner.nextInt();
            int tax = calculateTax(income);
            System.out.println("Tax: " + tax);
            totalTax += tax;
        }

        int averageTax = totalTax / n;
        System.out.println("Average: " + averageTax);
    }
}
