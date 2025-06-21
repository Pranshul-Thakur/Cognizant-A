abstract class Animal // main class because efficiency yayie yipee
{
    protected String name; // creating the strings name of the pet and what are they
    protected String type;
    
    public void setname(String n) // setter class for setting the name
    {
        name = n;
    }
    
    public abstract String speak(); // keeping the sound they make as virtual method for method overriding
    // destructor class because memory management in cpp - not needed in Java due to garbage collection
}

class Dog extends Animal // method overriding for class dog
{
    public Dog() // this stays same for all just animal type changes
    {
        type = "dog";
    }
    
    @Override
    public String speak() // overriding name of pet + what noise they make
    {
        return name + ", woof";
    }
}

class Cat extends Animal // same here
{
    public Cat()
    {
        type = "cat";
    }
    
    @Override
    public String speak()
    {
        return name + ", meow";
    }
}

class Bird extends Animal // same here
{
    public Bird()
    {
        type = "bird";
    }
    
    @Override
    public String speak()
    {
        return name + ", tweet";
    }
}

class pethome
{
    public static Animal setanimal(String type, String name)
    {
        if (type.equals("dog"))
        {
            Dog d = new Dog(); // creating a new reference variable d that points to new dog
            d.setname(name); // calling the setname method on new dog through the reference d
            return d;
        }
        else if (type.equals("cat"))
        {
            Cat c = new Cat(); // same here
            c.setname(name);
            return c;
        }
        else if (type.equals("bird"))
        {
            Bird b = new Bird(); // same here
            b.setname(name);
            return b;
        }
        else
        {
            throw new RuntimeException("Unknown animal type: " + type);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        String type = "dog";
        String name = "trump";
        Animal p = pethome.setanimal(type, name); // creating a instance and calling it
        System.out.println(p.speak());
        // delete p; - not needed in Java due to automatic garbage collection
    }
}
