class S {
    private static S instance; // declaring a static memeber and not a dtype because dtype can be instantiated inside the main class basically so that only one instance exists
    
    private S() {} // this is done to prevent instantiation in the main class 
    
    public static S getInstance() // the method and its getter class
    {
        if(instance == null) // checking if singleton has been created
        {
            instance = new S(); // creates a new instance of class and stores it at the pointer instance
        }
        return instance; // returns the pointer to the singleton instance
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        S obj1 = S.getInstance(); // creating 2 objects in main and calling them to confirm
        S obj2 = S.getInstance();
        
        if(obj1 == obj2) {
            System.out.println("True");
            System.out.println("address of obj1 : " + obj1);
            System.out.println("address of obj2 : " + obj2);
        }
        else {
            System.out.println("False");
            System.out.println("address of obj1 : " + obj1);
            System.out.println("address of obj2 : " + obj2);
        }
    }
}
