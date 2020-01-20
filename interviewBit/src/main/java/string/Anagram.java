package string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        char str1[] = ("geeksforgeeks").toCharArray();
        char str2[] = ("forgeeksgeeks").toCharArray();

        int count1[] = new int[256];
        Arrays.fill(count1, 0);
        int count2[] = new int[256];
        Arrays.fill(count2, 0);
        int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            System.out.println(str1[i]);
            count1[str1[i]]++;
            System.out.println(count1[str1[i]]);
            count2[str2[i]]++;
        }



    }
}
