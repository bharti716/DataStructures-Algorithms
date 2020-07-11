package demo;

import java.util.Arrays;
import java.util.Comparator;

public class Compares {

    public static void main(String args[]) {
        String[] cities = {"Bangalore", "Pune", "San Francisco", "New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "New York City"));

        Integer i = 120 ;
        Integer j = 120 ;
        System.out.println(i==j);
        i = 300 ;
        j = 300 ;
        System.out.println(i==j);
    }

    static class MySort implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}
