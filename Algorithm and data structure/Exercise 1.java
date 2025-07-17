import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | Qty: " + quantity + " | $" + price;
    }
}

class InventorySystem {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventorySystem inv = new InventorySystem();

        inv.addProduct(new Product(101, "Laptop", 10, 800.00));
        inv.addProduct(new Product(102, "Mouse", 50, 20.00));
        inv.addProduct(new Product(103, "Keyboard", 30, 45.50));

        System.out.println("Inventory:");
        inv.displayInventory();

        inv.updateProduct(101, 12, 790.00);
        inv.deleteProduct(102);

        System.out.println("\nUpdated Inventory:");
        inv.displayInventory();
    }
}
