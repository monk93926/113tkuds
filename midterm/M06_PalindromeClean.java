import java.util.Scanner;

public class M06_PalindromeClean {
    public static boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        
        // 清洗字串：只保留字母並轉小寫
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        // 使用雙指標法檢查回文
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        if (isPalindrome(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
