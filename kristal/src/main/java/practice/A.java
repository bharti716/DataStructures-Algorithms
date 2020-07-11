package practice;

public interface A {
        default void show() {
            System.out.println("default A");
        }
}
