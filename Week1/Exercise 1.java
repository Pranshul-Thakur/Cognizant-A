class S {
    private static S instance;

    private S() {}

    public static S getInstance() {
        if(instance == null) {
            instance = new S();
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        S obj1 = S.getInstance();
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