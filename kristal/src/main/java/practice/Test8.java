package practice;

import java.util.Properties;

public class Test8 {

    public static void main(String... arrrrrgs) {
        Properties p  = System.getProperties();
        p.setProperty("pirate", "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pirate");
        System.out.println(s);
    }
}
