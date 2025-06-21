import java.util.*;

class Product // class product for details of product, keeping it simple
{
    public int id;
    public String name;
    public double price;

    public Product(int id, String name, double price) // member initializer equivalent
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Store 
{
    private ArrayList<Product> products; // initialising a storage system

    public Store() 
    {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) // method for pushing back products into the storage
    {
        products.add(p);
    }

    public void search(String query)
    {
        System.out.println("Search results for : " + query);
        boolean found = false; // initialising a flag incase item doesnt exist

        for(int i = 0; i < products.size(); i++) // iterating through the dynamic array and checking if item exists
        {
            if (products.get(i).name.contains(query))
            {
                System.out.println(products.get(i).id + " - " + products.get(i).name + " - $" + products.get(i).price); // printing it out
                found = true;
            }
        }

        if(!found)
        {
            System.out.println("No product found"); // printing this if flag is false;
        }
    }

    public void displayAll()
    {
        System.out.println("all products");
        for(int i = 0; i < products.size(); i++)
        {
            System.out.println(products.get(i).id + ". " + products.get(i).name + " - $" + products.get(i).price); //displaying all the products
        }
    }
}

public class StoreManagement 
{
    public static void main(String[] args) 
    {
        Store s = new Store();

        s.addProduct(new Product(1, "Tata - Salt", 10));
        s.addProduct(new Product(2, "ToothBrush", 2));
        s.addProduct(new Product(3, "Water Bottle", 5)); //creating instances for example
        s.addProduct(new Product(4, "Towel", 30));

        Scanner scanner = new Scanner(System.in);
        String searchItem; // initializing searchitem to an empty string

        System.out.println("....STORE....");
        s.displayAll();

        System.out.print("Enter Product name to search: ");
        searchItem = scanner.nextLine();

        s.search(searchItem);
        
        scanner.close();
    }
}
