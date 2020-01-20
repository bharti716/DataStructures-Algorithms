package heaps;


import java.util.PriorityQueue;

public class RearrangeChar {

    public static void main(String[] args) {

        String str = "geeksforgeeks" ;
        int n = str.length();
        System.out.println("result is - " + canRearrange(str,n)) ;
    }
    static class Pair implements Comparable<Pair> {

        int freq ;
        char key ;

        public Pair(int freq, char key) {
            this.freq = freq;
            this.key = key;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.freq,this.freq);
        }
    }
    private static boolean canRearrange(String str , int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int chArray[] = new int[26];
        for(int i = 0 ; i < n ; i++){
            chArray[str.charAt(i)-'a']++ ;
        }

        for(char c = 'a' ; c <= 'z' ; c++){
            int index = c - 'a' ;
            if(chArray[index] != 0){
                pq.add(new Pair(chArray[index],c));
            }
        }

        str = "" ;
        Pair prev = new Pair(-1,'$');
        while(pq.size() != 0){
            Pair k = pq.poll();
            str = str + k.key ;
            if(prev.freq > 0){
                pq.add(prev);
            }
            k.freq-- ;
            prev = k ;
        }
        System.out.println(str);
        return n == str.length();
    }
}
