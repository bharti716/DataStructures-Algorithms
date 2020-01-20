import java.util.LinkedList;
import java.util.List;

public class grayCode {

    static List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> result = grayCode(3);
        result.stream().forEach(x->System.out.print(x + " "));
    }
}
