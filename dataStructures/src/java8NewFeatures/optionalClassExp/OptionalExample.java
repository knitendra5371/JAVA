package java8NewFeatures.optionalClassExp;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        String[] str = new String[10];

        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){  // check for value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.println(lowercaseString);
        }else
            System.out.println("string value is not present");

        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";// Setting value for 5th index
        Optional<String> checkNull1 = Optional.ofNullable(str[5]);
        if(checkNull1.isPresent()){  // It Checks, value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.println(lowercaseString);
        }else {
            System.out.println("String value is not present");
        }

        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
        Optional<String> checkNull2 = Optional.ofNullable(str[5]);
        checkNull2.ifPresent(value->System.out.println(value));   // printing value by using method reference
        checkNull2.ifPresent(System.out::println);   // printing value by using method reference
        System.out.println(checkNull2.get());    // printing value by using get method  if value is not present then it will throw exception: NoSuchElement
        System.out.println(str[5].toLowerCase());

        String value=null;
        Optional<String> op1 = Optional.empty(); // it will create empty optional object or container
        Optional<String> op2 = Optional.of(value); // it will create optional object or container with value if value is not null. if value is null then wil throw NullPointerException
        Optional<String> op3 = Optional.ofNullable(value); // it will create optional object or container if value!=null otherwise will create empty optional object or container. So It's a best way to create.



    }

}
