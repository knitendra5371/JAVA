package java8NewFeatures.lambdaExp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@FunctionalInterface  //It is optional
interface Drawable{
    public void draw();
}

@FunctionalInterface // it's optional
interface Sayable{
    public String say(String name);
}

@FunctionalInterface // it's optional
interface Addable{
    int add(int a,int b);
}

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        int width=10;

        //without lambda, Drawable implementation using anonymous class
        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing "+width);}
        };
        d.draw();

        // with lambda , Drawble implementation
        Drawable d1 = ()-> System.out.println("Drawing with Lambda =>"+width);
        d1.draw();

        // Lambda expression with single parameter.
        Sayable s = (name) ->{ return "I have nothing to say."; };
        System.out.println(s.say("Nitendra"));

        // Lambda expression with single parameter.
        Sayable s1 = (name)-> { return "Hello, "+name; };
        System.out.println(s1.say("Nitendra"));

        // You can omit function parentheses
        Sayable s2 = name -> { return "Hello, "+name; };
        System.out.println(s2.say("Nitendra"));

        // Multiple parameters in lambda expression
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));

        // Lambda expression with return keyword.
        Addable ad3=(int a,int b)->{ return (a+b); };
        System.out.println(ad3.add(100,200));

        // Java Lambda Expression Example: Foreach Loop
        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach((n)->System.out.println(n)); // forEach is a default method

        //Thread Example without lambda i.e class anonymous way
        Runnable r1=new Runnable(){
            public void run(){
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();
        //Thread Example with lambda
        Runnable r2=()->{
            System.out.println("Thread2 is running...");
        };
        Thread t2=new Thread(r2);
        t2.start();


        List<Product> list1=new ArrayList<Product>();

        //Adding Products
        list1.add(new Product(1,"HP Laptop",25000f));
        list1.add(new Product(3,"Keyboard",300f));
        list1.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(list1,(p1, p2)->{return p1.name.compareTo(p2.name);});
        for(Product p:list1){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }


        List<Product> list2=new ArrayList<>();
        list2.add(new Product(1,"Samsung A5",17000f));
        list2.add(new Product(3,"Iphone 6S",65000f));
        list2.add(new Product(2,"Sony Xperia",25000f));
        list2.add(new Product(4,"Nokia Lumia",15000f));
        list2.add(new Product(5,"Redmi4 ",26000f));
        list2.add(new Product(6,"Lenovo Vibe",19000f));

        // using lambda to filter data
        Stream<Product> filtered_data = list2.stream().filter(p -> p.price > 20000);

        // using lambda to iterate through collection
        filtered_data.forEach(product -> System.out.println(product.name+": "+product.price));

    }
}
