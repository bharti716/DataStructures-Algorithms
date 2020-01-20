package hashing;


import java.util.ArrayList;
import java.util.HashMap;


public class separateChaining {

    static class LinkedHashEntry {
        private int key;
        private LinkedHashEntry next;

        LinkedHashEntry(int value) {
            this.key = value;
            this.next = null;
        }

        private int getValue() {
            return this.key;
        }

        private LinkedHashEntry getNext() {
            return next;
        }

        private void setValue(int value) {
            this.key = value;
        }

        private void setNext(LinkedHashEntry next) {
            this.next = next;
        }

    }

    private static void separateChainingFunc(int arr[], int n, ArrayList<LinkedHashEntry> hashTable, int hashSize) {
        for(int p = 0 ; p < hashSize ; p++){
            hashTable.add(p,null);
        }
        for (int i = 0; i < n ; i++) {
            int tempIndex = (arr[i] % hashSize);
            if (hashTable.get(tempIndex) == null) {
                hashTable.set(tempIndex, new LinkedHashEntry(arr[i]));
            } else {
                LinkedHashEntry entry = hashTable.get(tempIndex);
                while (entry.getNext() != null && entry.getValue() != arr[i]) {
                    entry = entry.getNext();
                }
                entry.setNext(new LinkedHashEntry(arr[i]));
            }

        }

        for (int j = 0; j < hashTable.size(); j++) {
            if(hashTable.get(j) != null) {
                LinkedHashEntry entry = hashTable.get(j);
                System.out.print(j + "->");
                while (entry.getNext() != null) {
                    System.out.print(entry.getValue() + "->");
                    entry = entry.getNext();
                }
                System.out.print(entry.getValue());
                System.out.println("\n");
            }
        }
    }
    static long countNonRepeated(int arr[], int n)
    {
        HashMap<Integer,Long> map = new HashMap<>();
        long count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+(long)1);
                count++ ;
            }
            else {
                map.put(arr[i], (long) 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<LinkedHashEntry> hashTable = new ArrayList<>(10);
        separateChainingFunc(new int[]{92, 4, 14, 24, 44, 91}, 6, hashTable, 10);
        long result = countNonRepeated(new int[]{92, 4, 4, 24, 1, 1}, 6);
        System.out.println(result);

    }
}
