abstract class Animal {
    protected String name;
    protected String type;

    public void setname(String n) {
        name = n;
    }

    public abstract String speak();
}

class Dog extends Animal {
    public Dog() {
        type = "dog";
    }

    @Override
    public String speak() {
        return name + ", woof";
    }
}

class Cat extends Animal {
    public Cat() {
        type = "cat";
    }

    @Override
    public String speak() {
        return name + ", meow";
    }
}

class Bird extends Animal {
    public Bird() {
        type = "bird";
    }

    @Override
    public String speak() {
        return name + ", tweet";
    }
}

class pethome {
    public static Animal setanimal(String type, String name) {
        if (type.equals("dog")) {
            Dog d = new Dog();
            d.setname(name);
            return d;
        } else if (type.equals("cat")) {
            Cat c = new Cat();
            c.setname(name);
            return c;
        } else if (type.equals("bird")) {
            Bird b = new Bird();
            b.setname(name);
            return b;
        } else {
            throw new RuntimeException("Unknown animal type: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String type = "dog";
        String name = "trump";
        Animal p = pethome.setanimal(type, name);
        System.out.println(p.speak());
    }
}