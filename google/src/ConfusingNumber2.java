/**
 We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)
 Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
*/

public class ConfusingNumber2 {

    private int count = 0;
    private int n = 0;

    public int confusingNumberII(int N) {
        n = N;
        search(0);
        return count;
    }

    private void search(long num) {
        if (num > n) return;
        if (num != 0) {
            if (rotate(num) != num) ++count;
        }
        if (num != 0) search(num * 10);
        search(num * 10 + 1);
        search(num * 10 + 6);
        search(num * 10 + 8);
        search(num * 10 + 9);
    }

    private long rotate(long x) {
        long y = 0;
        for (; x != 0; x /= 10) {
            int k = (int) (x % 10);
            switch (k) {
                case 6:
                    k = 9;
                    break;
                case 9:
                    k = 6;
                    break;
            }
            y = y * 10 + k;
        }
        return y;
    }
}
