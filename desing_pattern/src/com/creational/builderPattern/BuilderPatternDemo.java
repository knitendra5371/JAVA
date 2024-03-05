package com.creational.builderPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        Arrays.fill(arr1,Integer.MAX_VALUE);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("index = "+i+" value = "+arr1[i]);
        }


        Integer[][] arr2 = new Integer[4][6];
        for (Integer[] ints : arr2) {
            Arrays.fill(ints, -1);
        }

        for (Integer[] ints : arr2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }

        List<Integer> iList = new ArrayList<>(Collections.nCopies(5,-2));
        iList.forEach(item-> System.out.print(item+" "));

        System.out.println();

        List<List<Integer>> iList2 = new ArrayList<>();

        for (int i = 0; i <3 ; i++) {
            iList2.add(Collections.nCopies(4,-5));
        }

        for (List<Integer> integers : iList2) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }

    }
}
