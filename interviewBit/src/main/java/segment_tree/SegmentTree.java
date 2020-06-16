package segment_tree;


public class SegmentTree {

    private InfoTrio st[];
    private InfoTrio info ;

    class InfoTrio{
        int sum ;
        int max ;
        int min ;

        InfoTrio(int sum, int max, int min) {
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }

    private SegmentTree(int array[], int n) {
        int size = getResultArraySize(n);
        st = new InfoTrio[size];
        constructTree(array, 0, n - 1, 0);

    }

    private int getResultArraySize(int n) {

        int x = (int) (int) (Math.ceil(Math.log(n) / Math.log(2)));
        return (int) (2 * (Math.pow(2, x)) - 1);
    }

    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    private InfoTrio constructTree(int input[], int start, int end, int curr) {
        if (start == end) {
            st[curr] = new InfoTrio(input[start], input[start], input[start]);
            return st[curr];
        }
        int mid = getMid(start, end);

        constructTree(input, start, mid, 2 * curr + 1) ;
        constructTree(input, mid + 1, end, 2 * curr + 2);

        st[curr] = new InfoTrio(st[2*curr+1].sum + st[2*curr+2].sum,Math.max(st[2*curr+1].max,st[2*curr+2].max),
                Math.min(st[2*curr+1].min,st[2*curr+2].min));

        return st[curr];
    }

    private void updateValue(int[] arr, int n, int index, int key) {

        if (index < 0 || index > n - 1) {
            System.out.println("Erroneous input");
            return;
        }
        int diff = key - arr[index];
        arr[index] = key;

        updateValueUtil(0, n - 1, index, diff, 0);
    }

    private void updateValueUtil(int ss, int se, int i, int diff, int si) {

        if (i < ss || i > se)
            return;

        st[si].sum = st[si].sum + diff;
        if (ss != se) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    int getSum(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si].sum;

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }


    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int m = arr.length;

        SegmentTree tree = new SegmentTree(arr, m);
        // Build segment tree from given array 

        // Print sum of values in array from index 1 to 3 
        System.out.println("Sum of values in given range = " +
                tree.getSum(m, 1, 3));

        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes 
        tree.updateValue(arr, m, 1, 10);

        // Find sum after the value is updated 
        System.out.println("Updated sum of values in given range = " +
                tree.getSum(m, 1, 3));

        System.out.println("Minimum of values in given range = " +
                tree.getMin(m, 3, 5));

        System.out.println("Maximum  of values in given range = " +
                tree.getMax(m, 3, 5));


    }

    private int getMax(int m, int qs, int qe) {

        if(qs < 0 || qe > m){
            System.out.println("Range erroneous");
            return -1;
        }

        InfoTrio result = getMinMaxUtil(0,m-1,qs,qe,0) ;
        return result.max ;

    }

    private int getMin(int m, int qs, int qe) {

        if(qs < 0 || qe > m){
            System.out.println("Range erroneous");
            return -1;
        }

        InfoTrio result = getMinMaxUtil(0,m-1,qs,qe,0) ;
        return result.min ;

    }

    private InfoTrio getMinMaxUtil(int ss, int se, int qs, int qe, int si) {

        if(qs <= ss && qe >= se){

            return st[si];
        }
        if(se < qs || ss > qe ){
            return new InfoTrio(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        int mid = getMid(ss,se);
        InfoTrio left = getMinMaxUtil(ss,mid,qs,qe,2*si+1);
        InfoTrio right = getMinMaxUtil(mid+1,se,qs,qe,2*si+2);
        return new InfoTrio(0,Math.max(left.max,right.max),Math.min(left.min,right.min)) ;
    }


}
