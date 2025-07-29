import java.util.Scanner;
public class ds_02{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入圓的半徑:");
        double r = scanner.nextDouble();
        double area = Math.PI*r*r;
        System.out.printf("面積等於:%.2f\n",area);
        scanner.close();
    }
}