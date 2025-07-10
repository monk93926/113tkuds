class ArrayBoundsErrorDemo {
   
    static void demonstrateCommonErrors() {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("陣列內容：" + java.util.Arrays.toString(numbers));
        System.out.printf("陣列長度：%d\n", numbers.length);
        System.out.printf("有效索引範圍：0 到 %d\n", numbers.length - 1);
        System.out.println();
        
        
        System.out.println("=== 錯誤情況 1：使用陣列長度作為索引 ===");
        try {
            int value = numbers[numbers.length]; 
            System.out.println("這行不會執行到");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("捕獲錯誤：%s\n", e.getMessage());
            System.out.println("原因：索引 5 超出有效範圍 [0, 4]");
        }
        
       
        System.out.println("\n=== 錯誤情況 2：負數索引 ===");
        try {
            int value = numbers[-1];  
            System.out.println("這行不會執行到");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("捕獲錯誤：%s\n", e.getMessage());
            System.out.println("原因：陣列索引不能為負數");
        }
        
        System.out.println("\n=== 錯誤情況 3：迴圈邊界錯誤 ===");
        try {
            System.out.println("錯誤的迴圈寫法：");
            for (int i = 0; i <= numbers.length; i++) {  
                System.out.printf("numbers[%d] = %d\n", i, numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("在迴圈中捕獲錯誤：%s\n", e.getMessage());
        }
    }
    
   
    static int safeGet(int[] array, int index, int defaultValue) {
        if (array == null) {
            System.out.println("警告：陣列為 null，返回預設值");
            return defaultValue;
        }
        
        if (index < 0 || index >= array.length) {
            System.out.printf("警告：索引 %d 超出範圍 [0, %d]，返回預設值\n", 
                            index, array.length - 1);
            return defaultValue;
        }
        
        return array[index];
    }
    
    
    static boolean safeSet(int[] array, int index, int value) {
        if (array == null) {
            System.out.println("錯誤：無法在 null 陣列上設定值");
            return false;
        }
        
        if (index < 0 || index >= array.length) {
            System.out.printf("錯誤：無法在索引 %d 設定值，有效範圍是 [0, %d]\n", 
                            index, array.length - 1);
            return false;
        }
        
        array[index] = value;
        System.out.printf("成功：array[%d] = %d\n", index, value);
        return true;
    }
    
    public static void main(String[] args) {
        demonstrateCommonErrors();
        
        System.out.println("\n=== 安全存取示範 ===");
        int[] numbers = {10, 20, 30, 40, 50};
        
       
        System.out.println("正常存取：" + safeGet(numbers, 2, -1));
        System.out.println("越界存取：" + safeGet(numbers, 10, -1));
        System.out.println("負數索引：" + safeGet(numbers, -1, -1));
        System.out.println("null 陣列：" + safeGet(null, 0, -1));
        
        System.out.println("\n安全設定測試：");
        safeSet(numbers, 2, 999);   
        safeSet(numbers, 10, 888);  
        safeSet(null, 0, 777);      
        
        System.out.println("最終陣列：" + java.util.Arrays.toString(numbers));
    }
}