package practice;

public interface B {
        default void show(){
            System.out.println("default B");
        }
}
