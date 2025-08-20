import java.util.*;

public class M03_TopKConvenience {
    static class Product {
        String name;
        int qty;

        Product(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PriorityQueue<Product> minHeap = new PriorityQueue<>(K, (a, b) -> 
            a.qty == b.qty ? a.name.compareTo(b.name) : Integer.compare(a.qty, b.qty)
        );

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int qty = scanner.nextInt();
            scanner.nextLine(); // consume newline
            minHeap.offer(new Product(name, qty));

            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        List<Product> result = new ArrayList<>(minHeap);
        result.sort((a, b) -> b.qty == a.qty ? a.name.compareTo(b.name) : Integer.compare(b.qty, a.qty));

        for (Product p : result) {
            System.out.println(p.name + " " + p.qty);
        }
    }
}
