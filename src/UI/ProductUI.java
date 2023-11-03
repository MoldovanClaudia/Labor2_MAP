package UI;

import Controller.ProductController;
import Domain.Product;
import Domain.ProductStore;


import java.util.ArrayList;
import java.util.Scanner;

public class ProductUI {
    public void ProductCase(ProductController productController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. Update Product");
        System.out.println("4. Get All Products");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter product ID: ");
                int productID = scanner.nextInt();
                System.out.print("Enter product name: ");
                String productName = scanner.next();
                System.out.print("Enter product description: ");
                String productDescription = scanner.next();
                System.out.print("Enter product category: ");
                String productCategory = scanner.next();
                System.out.print("Enter product price: ");
                float productPrice = scanner.nextFloat();
                System.out.print("Enter supplier ID: ");
                int supplierID = scanner.nextInt();
                System.out.print("Enter product quantity: ");
                int productQuantity = scanner.nextInt();
                System.out.print("Enter store ID: ");
                int storeID = scanner.nextInt();

                productController.addProduct(productID, productName, productDescription, productCategory, productPrice, supplierID, productQuantity, storeID);

                System.out.println("Product added successfully.");
                break;
            case 2:
                System.out.print("Enter product ID to delete: ");
                int productID2 = scanner.nextInt();

                // Confirmation to delete
                System.out.print("Are you sure you want to delete this product and associated product stores? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    Product product = new Product(productID2, "", "", "", 0.0f, 0, 0);
                    ProductStore productStore = new ProductStore(productID2, 0);
                    productController.deleteProduct(product, productStore);
                    System.out.println("Product and associated product stores deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<Product> products = productController.getAllProducts();

                if (products.isEmpty()) {
                    System.out.println("No products found.");
                } else {
                    System.out.println("List of Products:");
                    for (Product productIn : products) {
                        System.out.println(productIn);
                    }
                }
                break;
        }
    }
}
