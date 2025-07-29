import java.util.Scanner;
public class searchnumber {
    public static void main(String[] args) {
        int[] s = {1,3,5,7,9,11,13};
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入要查的數字:");
        int x = scanner.nextInt();
        boolean found = false;
        for(int num :s ) {
            if (num == x){
                found = true;
                break;
            }
            
        }
    }
}