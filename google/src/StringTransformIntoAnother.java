import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 */

public class StringTransformIntoAnother {

    public boolean canConvert(String str1, String str2) {
        HashSet<Character> s2 = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            s2.add(str2.charAt(i));
            if (map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
        }
        if (!str1.equals(str2) && map.size() == 26 && s2.size() == 26) {
            return false;
        }
        return true;
    }
}
