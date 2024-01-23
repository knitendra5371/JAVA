package java8NewFeatures.stringJoinerExp;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter

        // Adding values to StringJoiner
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");
        joinNames.add("Raheem");

        System.out.println(joinNames);


        StringJoiner joinNames1 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

        // Adding values to StringJoiner
        joinNames1.add("Rahul");
        joinNames1.add("Raju");
        joinNames1.add("Peter");
        joinNames1.add("Raheem");

        System.out.println(joinNames1);



        StringJoiner joinNames2 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

        // Adding values to StringJoiner
        joinNames2.add("Rahul");
        joinNames2.add("Raju");

        // Creating StringJoiner with :(colon) delimiter
        StringJoiner joinNames3 = new StringJoiner(":", "[", "]");  // passing colon(:) and square-brackets as delimiter

        // Adding values to StringJoiner
        joinNames3.add("Peter");
        joinNames3.add("Raheem");

        // Merging two StringJoiner
        StringJoiner merge = joinNames2.merge(joinNames3);
        System.out.println(merge);



        StringJoiner joinNames5 = new StringJoiner(","); // passing comma(,) as delimiter

        // Prints nothing because it is empty
        System.out.println(joinNames5);

        // We can set default empty value.
        joinNames5.setEmptyValue("It is empty");
        System.out.println(joinNames5);


        // Adding values to StringJoiner
        joinNames5.add("Rahul");
        joinNames5.add("Raju");
        System.out.println(joinNames5);

        // Returns length of StringJoiner
        int length = joinNames5.length();
        System.out.println("Length: "+length);

        // Returns StringJoiner as String type
        String str = joinNames5.toString();
        System.out.println(str);

        // Now, we can apply String methods on it
        char ch = str.charAt(3);
        System.out.println("Character at index 3: "+ch);

        // Adding one more element
        joinNames5.add("Sorabh");
        System.out.println(joinNames5);

        // Returns length
        int newLength = joinNames5.length();
        System.out.println("New Length: "+newLength);

    }
}
