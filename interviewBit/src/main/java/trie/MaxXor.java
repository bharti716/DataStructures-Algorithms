package trie;

public class MaxXor {

    private static TrieNode root ;
    private static final int INT_SIZE = 32;

    static class TrieNode{

        TrieNode children[] = new TrieNode[2];
        int value ;

        public TrieNode(){

            value = 0 ;
            children[0] = null ;
            children[1] = null ;
        }
    }
    private static void insertKey(int key){
        TrieNode temp = root ;
        for(int i = INT_SIZE-1 ; i >= 0 ;i--){
            int val = (key & (1<<i)) >= 1 ? 1 : 0;

            if(temp.children[val] == null){
                temp.children[val] = new TrieNode();
            }
            temp = temp.children[val] ;
        }
        temp.value = key ;
    }
    private static int maxSubarrayXOR(int arr[], int n){
        root = new TrieNode();
        insertKey(0);
        int result = Integer.MIN_VALUE ;
        int pre_xor = 0 ;

        for(int j = 0 ; j < n ; j++){

            pre_xor = pre_xor^arr[j];
            insertKey(pre_xor);

            result = Math.max(result, query(pre_xor));

        }
        return result ;

    }

    private static int query(int pre_xor) {
        TrieNode temp = root ;
        for(int i = INT_SIZE-1 ; i >=0 ; i++){
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;

            // Traverse Trie, first look for a
            // prefix that has opposite bit
            if (temp.children[1-val] != null)
                temp = temp.children[1-val];

                // If there is no prefix with opposite
                // bit, then look for same bit.
            else if (temp.children[val] != null)
                temp = temp.children[val];
        }
        return pre_xor^(temp.value);
    }

    public static void main(String[] args) {
        int array[] = {8, 1, 2, 12, 7, 6};
        int n = array.length;
        System.out.println("Max subarray XOR is " +
                maxSubarrayXOR(array, n));
    }
}
