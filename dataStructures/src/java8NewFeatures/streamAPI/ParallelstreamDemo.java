package java8NewFeatures.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelstreamDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 4, 7, 9, 8, 10);

        integers.parallelStream().map(ele -> ele*ele).forEach(System.out::println);
    }
}
