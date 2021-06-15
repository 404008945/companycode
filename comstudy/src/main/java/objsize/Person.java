package objsize;


import lombok.Data;

@Data
public class Person  extends People {
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static void main(String[] args) {
    }
}
