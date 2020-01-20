import java.util.ArrayList;

public class reverseArrayInGroups {

    static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        int iterator = (int) Math.ceil((double) n/k);
        System.out.println("iterator - " + iterator);
        for(int loop = 0 ; loop < iterator ; loop++){
            if(loop != iterator-1) {
                arrayReversal(mv, loop * k, k - 1);
            }
            else arrayReversal(mv, loop * k, (n%k)-1);
        }

        return mv;
    }
    static void arrayReversal(ArrayList<Integer> arr,int i,int k)
    {
        int temp ;
        int j = i + k ;
        while(i != j && !(j < i)){
            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++ ;
            j-- ;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> result = reverseInGroups(new ArrayList<Integer>(){
            { add(1);
              add(2);
              add(3);
              add(4);
              add(5);
            }
        },5,3) ;

        result.stream().forEach(x-> System.out.print(x + " "));
    }
}
