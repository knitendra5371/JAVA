package java8NewFeatures.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private List<String> phones;

    public Employee(int id, String name, List<String> phones) {
        this.id = id;
        this.name = name;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}

public class FlatMapDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"nitendra", Arrays.asList("1234567890","2134567890","3214567890"));
        Employee e2 = new Employee(2,"jitendra", Arrays.asList("2345678901","3124567890"));
        Employee e3 = new Employee(3,"Aarush", Arrays.asList("9087654321","789604321"));
//        Employee e4 = new Employee(3,"Aarush", Arrays.asList("9087654321","789604321"));

//        System.out.println(e3.equals(e4));

        List<Employee> employees = Arrays.asList(e1, e2, e3);

        System.out.println("\n****************** Map ****************");

        List<List<String>> phoneNumbers = employees.stream().map(Employee::getPhones).collect(Collectors.toList());
        System.out.println(phoneNumbers);
        List<String> employeesName = employees.stream().map(employee -> employee.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(employeesName);

        System.out.println("\n****************** Flat map ****************");

        List<String> phoneNumberList = employees.stream().flatMap(e -> e.getPhones().stream()).collect(Collectors.toList());
        System.out.println(phoneNumberList);

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

//        int[] ints = Arrays.stream(arr).flatMapToInt(ele -> Arrays.stream(ele)).toArray(); // it will work also
        int[] ints = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        System.out.println(Arrays.toString(ints));

        String str1="nitendra";
        char[] ch1 = str1.toCharArray();
        System.out.println(ch1[0]);

        String str2 = new String("Jitendra");
        char[] ch2 = str2.toCharArray();
        System.out.println(ch2[0]);
    }
}
