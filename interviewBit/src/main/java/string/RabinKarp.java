package string;

public class RabinKarp {

    static int d = 256;

    static int createHash(char[] str, int x, int prime) {
        int hash = 0;
        for (int k = 0; k <= x; k++) {
            hash += str[k] * Math.pow(prime, k);
        }
        return hash;
    }

    static int rollingHash(char[] txtArray, int oldIndex, int newIndex, int oldHash, int patlen, int prime) {
        int newhash = oldHash - txtArray[oldIndex];
        newhash = newhash / prime;
        newhash += txtArray[newIndex] * Math.pow(prime, patlen - 1);
        return newhash;
    }

    static boolean checkEqual(char str1[], int start1, int end1, char str2[], int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (str1[start1] != str2[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    static boolean search(String pat, String txt, int q) {
        char[] patArray = pat.toCharArray();
        char[] txtArray = txt.toCharArray();

        int m = patArray.length;
        int n = txtArray.length;

        int patHash = createHash(patArray, m - 1, q);
        int txtHash = createHash(txtArray, m - 1, q);

        for (int i = 1; i <= n - m + 1; i++) {
            if (patHash == txtHash) {
                return checkEqual(txtArray, i - 1, i + m - 2, patArray, 0, m - 1);
            }
            if (i < n - m + 1) {
                txtHash = rollingHash(txtArray, i - 1, i + m - 1, txtHash, m, q);
            }
        }
        return false;
    }
}
