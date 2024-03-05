package Imp_Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorsOfANumber {
    static int SIZE = 1000000;
    static int[] primes;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scan.nextInt();

        if(number <=1){
            System.out.println("Number should be greater than 1 .");
            return;
        }


        sieve();

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < SIZE; i++) {
            if(primes[i]==1)
                primeList.add(i);

        }
//        System.out.println(primeList);
        List<Integer> factors = new ArrayList<>();
        int idx=0;
        int factor = primeList.get(idx);
        while( number > 1){
//            if(number < factor ) break;
            if(number%factor==0){
                factors.add(factor);
                number/=factor;
            }else {
                factor = primeList.get(++idx);
            }
        }


        System.out.println(factors);

    }

    private static void sieve() {
        primes = new int[SIZE];
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;

//        System.out.println(arr[0]+" "+arr[1]);
        for (int i = 2; i * i <= SIZE; i++) {
            if (primes[i] != 0) {
                for (int j = 2; j * i < SIZE; j++) {
                    primes[j * i] = 0;
                }
            }
        }

    }
}
