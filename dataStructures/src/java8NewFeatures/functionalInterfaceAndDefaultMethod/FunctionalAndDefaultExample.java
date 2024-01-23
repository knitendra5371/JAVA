package java8NewFeatures.functionalInterfaceAndDefaultMethod;

// functional interface or SAM (Exactly one single abstract method)
@FunctionalInterface
interface sayable{
    void say(String msg);   // abstract method
    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);

    // It can contain any number of default methods.
    default void doIt(){
        System.out.println("Do it now");
    }

    // static method , It can contain any number of static methods.
    static void sayLouder(String msg){
        System.out.println(msg);
    }
}

public class FunctionalAndDefaultExample implements sayable{
    @Override
    public void say(String msg){
        System.out.println(msg);
    }

    // We can override default method also
   /* public void doIt(){
        System.out.println("LOL");
    }*/

    public static void main(String[] args) {
        FunctionalAndDefaultExample fie = new FunctionalAndDefaultExample();
        fie.say("Hello there");

        fie.doIt();
    }
}
