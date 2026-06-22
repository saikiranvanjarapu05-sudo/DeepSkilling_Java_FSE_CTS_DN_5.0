public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        int targetId = 104;
        long startLinear = System.nanoTime();
        Product linearResult =SearchOperations.linearSearch(products, targetId);
        long endLinear = System.nanoTime();

        long startBinary = System.nanoTime();
        Product binaryResult =SearchOperations.binarySearch(products, targetId);
        long endBinary = System.nanoTime();

        System.out.println("===== LINEAR SEARCH =====");
        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println("Execution Time: "+ (endLinear - startLinear)+ " ns");
        System.out.println("Best Case  : O(1)");
        System.out.println("Average Case: O(n)");
        System.out.println("Worst Case : O(n)");
        System.out.println();
        System.out.println("===== BINARY SEARCH =====");
        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println("Execution Time: " + (endBinary - startBinary) + " ns");
        System.out.println("Best Case  : O(1)");
        System.out.println("Average Case: O(log n)");
        System.out.println("Worst Case : O(log n)");
    }
}
