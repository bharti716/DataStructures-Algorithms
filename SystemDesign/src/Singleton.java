public class Singleton {

    private int a;
    private String b;

    Singleton(int a, String b) {

        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return (a + ":" + b) ;
    }
    public static void main(String[] args) {
        Singleton obj = new Singleton(4, "wow");
        String result = String.valueOf(obj);

        System.out.println("string representation of an object is - " + result);

        String  test = "bca" ;

        System.out.println("result - " + test.substring(1));
    }
}
