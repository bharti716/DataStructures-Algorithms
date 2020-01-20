package hashing;

import java.util.HashMap;
import java.util.Map;

public class linearProbing {

    public static boolean isAnagram(String s1,String s2)
    {

        int n = s1.length() ;
        int m = s2.length() ;
        int count = 0 ;

        if( n != m){
            return false ;
        }
        Map<Character, Integer> map = new HashMap<>() ;
        for(int i = 0 ; i< n ; i++){
            if(!(map.containsKey(s1.charAt(i)))){
                map.put(s1.charAt(i), 1) ;
            }
            else {
                map.put(s1.charAt(i) , map.get(s1.charAt(i))+1) ;
            }
        }

        for(int j = 0 ; j< m ; j++){
            if((map.containsKey(s2.charAt(j))) ){
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);
            }
            else return false ;
        }

        return map.values().stream().allMatch(x-> x.equals(count));

    }
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeekz";
        if (isAnagram(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other") ;
    }
}
