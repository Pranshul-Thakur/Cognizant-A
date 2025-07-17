import java.util.*;

class Product {
    public int id;
    public String name;
    public double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Store {
    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void search(String query) {
        System.out.println("Search results for : " + query);
        boolean found = false;

        for(int i = 0; i < products.size(); i++) {
            if (products.get(i).name.contains(query)) {
                System.out.println(products.get(i).id + " - " + products.get(i).name + " - $" + products.get(i).price);
                found = true;
            }
        }

        if(!found) {
            System.out.println("No product found");
        }
    }

    public void displayAll() {
        System.out.println("all products");
        for(int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).id + ". " + products.get(i).name + " - $" + products.get(i).price);
        }
    }
}

public class StoreManagement {
    public static void main(String[] args) {
        Store s = new Store();

        s.addProduct(new Product(1, "Tata - Salt", 10));
        s.addProduct(new Product(2, "ToothBrush", 2));
        s.addProduct(new Product(3, "Water Bottle", 5));
        s.addProduct(new Product(4, "Towel", 30));

        Scanner scanner = new Scanner(System.in);
        String searchItem;

        System.out.println("....STORE....");
        s.displayAll();

        System.out.print("Enter Product name to search: ");
        searchItem = scanner.nextLine();

        s.search(searchItem);
        
        scanner.close();
    }
}