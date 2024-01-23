package java8NewFeatures.methodReference;

import java.util.function.BiFunction;

interface Sayable{
    void say();
}

class Arithmetic{
    public static int add(int a, int b){
        return a+b;
    }
}

interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}

public class MethodRefExample {
    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static void ThreadStatus(){
        System.out.println("Thread is running...");
    }
    public void saySomething1(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = MethodRefExample::saySomething;
        // Calling interface method
        sayable.say();


        Thread t2=new Thread(MethodRefExample::ThreadStatus);
        t2.start();

        BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
        int result = adder.apply(10, 20);
        System.out.println(result);


        MethodRefExample methodReference = new MethodRefExample();
        // Referring non-static method using reference
        Sayable sayable1 = methodReference::saySomething1;
        // Calling interface method
        sayable1.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new MethodRefExample()::saySomething1; // You can use anonymous object also
        // Calling interface method
        sayable2.say();


        Thread t3=new Thread(new MethodRefExample()::printnMsg);
        t3.start();

        // Reference to a Constructor
        Messageable hello = Message::new;
        hello.getMessage("Hello");

    }

    public void printnMsg(){
        System.out.println("Hello, this is instance method");
    }
}