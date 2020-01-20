import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class phoneNumbers {

    static void possibleWords(int a[], int N)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int p =0 ; p< a.length ; p++){
            stringBuilder.append(a[p]);
        }
        String digits = stringBuilder.toString();
        System.out.println("digits:" + digits);
        HashMap<Character, char[]> dict = new HashMap<>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0){
            System.out.println(" ");
        }

        char[] arr = new char[digits.length()];
        helper(digits, 0, dict, result, arr);

        if(!result.isEmpty()) {
            for (String s : result) {
                System.out.print(s + " ");
            }
        }
    }

    static void helper(String digits, int index, HashMap<Character, char[]> dict,
                       List<String> result, char[] arr){
        if(index==digits.length()){
            result.add(new String(arr));
            return;
        }

        char number = digits.charAt(index);
        char[] candidates = dict.get(number);
        for(int i=0; i<candidates.length; i++){
            arr[index]=candidates[i];
            helper(digits, index+1, dict, result, arr);
        }
    }
    public static void main(String[] args) {
        possibleWords(new int[]{2,4,5},3);
    }
}
