

public class ArraySearcher {

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; 
            }
        }
        return -1; 
    }

  
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
     
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int search1 = 67;
        int search2 = 100;

     
        int index1 = findElement(numbers, search1);
        int count1 = countOccurrences(numbers, search1);
        if (index1 != -1) {
            System.out.println("數字 " + search1 + " 出現在索引位置: " + index1);
            System.out.println("數字 " + search1 + " 出現次數: " + count1);
        } else {
            System.out.println("數字 " + search1 + " 未出現在陣列中。");
        }

     
        int index2 = findElement(numbers, search2);
        int count2 = countOccurrences(numbers, search2);
        if (index2 != -1) {
            System.out.println("數字 " + search2 + " 出現在索引位置: " + index2);
            System.out.println("數字 " + search2 + " 出現次數: " + count2);
        } else {
            System.out.println("數字 " + search2 + " 未出現在陣列中。");
        }
    }
}
