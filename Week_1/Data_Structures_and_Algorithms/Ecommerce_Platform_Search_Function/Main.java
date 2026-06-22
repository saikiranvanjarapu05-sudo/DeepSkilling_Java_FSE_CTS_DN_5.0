import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };
       
        System.out.println("Enter the ProductId:");
        int targetId = sc.nextInt();


        System.out.println("Linear Search:");

        Product linearResult =
                SearchOperations.linearSearch(products, targetId);

        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Product Not Found");
        }

        System.out.println("\nBinary Search:");

        Product binaryResult =
                SearchOperations.binarySearch(products, targetId);

        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Product Not Found");
        }
    }
}