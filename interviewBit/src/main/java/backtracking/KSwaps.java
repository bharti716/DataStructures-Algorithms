package backtracking;

public class KSwaps {
    public static void main(String[] args) {
        String str = "1234567";
        int k = 3;
        char chArray[] = str.toCharArray();
        String res = "";
        System.out.println("result is - " + largestNoInKSwaps(chArray, res, k));
    }

    private static String largestNoInKSwaps(char cArray[], String max, int k) {
        if (k == 0) {
            return max;
        }
        int n = cArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (cArray[j] > cArray[i]) {
                    char temp = cArray[i];
                    cArray[i] = cArray[j];
                    cArray[j] = temp;

                    String st = new String(cArray);

                    if (max.compareTo(st) < 0) {
                        max = st;
                    }
                    max = largestNoInKSwaps(cArray, max, k - 1);

                    temp = cArray[i];
                    cArray[i] = cArray[j];
                    cArray[j] = temp;
                }
            }
        }
        return max ;
    }
}
