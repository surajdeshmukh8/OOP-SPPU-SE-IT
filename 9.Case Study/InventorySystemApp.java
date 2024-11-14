/**9.Using concepts of Object-Oriented programming java develop solution for  one application 
 Banking system having following operations : 
Inventory management system having following operations :
1. List of all products 
2. Display individual product information 
3. Purchase 
4. Shipping
5. Balance stock
6. Loss and Profit calculation.*/


import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    // Constructor to initialize product
    public Product(int productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.soldQuantity = 0;
    }

    // Getters for product details
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public int getSoldQuantity() { return soldQuantity; }

    // Purchase product - adds to stock
    public void purchase(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
            System.out.println(quantity + " units added to stock of " + productName + ".");
        } else {
            System.out.println("Quantity must be positive.");
        }
    }

    // Ship product - reduces stock if available
    public void ship(int quantity) {
        if (quantity > 0) {
            if (quantity > stockQuantity) {
                System.out.println("Insufficient stock.");
            } else {
                stockQuantity -= quantity;
                soldQuantity += quantity;
                System.out.println(quantity + " units shipped from " + productName + " stock.");
            }
        } else {
            System.out.println("Quantity must be positive.");
        }
    }

    // Display individual product information
    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Stock Quantity: " + stockQuantity);
        System.out.println("Total Sold Quantity: " + soldQuantity);
    }

    // Calculate profit or loss (simple method, assumes cost is a portion of selling price)
    public double calculateProfitOrLoss(double costPrice) {
        return (price - costPrice) * soldQuantity;
    }
}

class InventoryManagementSystem {
    private ArrayList<Product> productList = new ArrayList<>();

    // Method to add product to inventory
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Display list of all products
    public void displayAllProducts() {
        System.out.println("Product List:");
        for (Product product : productList) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() + ", Stock: " + product.getStockQuantity());
        }
    }

    // Display individual product information
    public void displayProductInfo(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            product.displayInfo();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to purchase products and add to stock
    public void purchaseProduct(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.purchase(quantity);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to ship products (reduce stock)
    public void shipProduct(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.ship(quantity);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display balance stock for each product
    public void displayStockBalance() {
        System.out.println("Stock Balance:");
        for (Product product : productList) {
            System.out.println("Product: " + product.getProductName() + ", Stock Remaining: " + product.getStockQuantity());
        }
    }

    // Calculate and display profit or loss for each product
    public void displayProfitOrLoss(double costPrice) {
        System.out.println("Profit or Loss:");
        for (Product product : productList) {
            double profitOrLoss = product.calculateProfitOrLoss(costPrice);
            System.out.println("Product: " + product.getProductName() + ", Profit/Loss: $" + profitOrLoss);
        }
    }

    // Helper method to find product by ID
    private Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

public class InventorySystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Adding some sample products
        ims.addProduct(new Product(1, "Laptop", 1200.0, 50));
        ims.addProduct(new Product(2, "Smartphone", 800.0, 100));
        ims.addProduct(new Product(3, "Tablet", 500.0, 75));

        int choice;
        do {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. List All Products");
            System.out.println("2. Display Product Information");
            System.out.println("3. Purchase Product");
            System.out.println("4. Ship Product");
            System.out.println("5. Display Stock Balance");
            System.out.println("6. Calculate Profit or Loss");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ims.displayAllProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID to view details: ");
                    int productId = scanner.nextInt();
                    ims.displayProductInfo(productId);
                    break;
                case 3:
                    System.out.print("Enter Product ID to purchase: ");
                    productId = scanner.nextInt();
                    System.out.print("Enter quantity to purchase: ");
                    int purchaseQuantity = scanner.nextInt();
                    ims.purchaseProduct(productId, purchaseQuantity);
                    break;
                case 4:
                    System.out.print("Enter Product ID to ship: ");
                    productId = scanner.nextInt();
                    System.out.print("Enter quantity to ship: ");
                    int shipQuantity = scanner.nextInt();
                    ims.shipProduct(productId, shipQuantity);
                    break;
                case 5:
                    ims.displayStockBalance();
                    break;
                case 6:
                    System.out.print("Enter cost price for profit/loss calculation: ");
                    double costPrice = scanner.nextDouble();
                    ims.displayProfitOrLoss(costPrice);
                    break;
                case 7:
                    System.out.println("Exiting Inventory Management System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
