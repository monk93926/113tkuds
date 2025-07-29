import java.util.Scanner;
public class ds_01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("第一個整數:");
        int a = scanner.nextInt();
        System.out.print("第二個整數:");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("總和等於:"+sum);
        scanner.close();
    }
}