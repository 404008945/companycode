package innerc;

public class ClassB extends  ClassA{
    public static void classAmethod() {
        System.out.println("classAmethodB");
    }
    static class ClassC{
      public void sayHello(){
          System.out.println("hello");
      }


    }
    class ClassD extends ClassC{

    }

    public static void main(String[] args) {
        ClassD classD = new ClassB().new ClassD();
        classD.sayHello();

    }
}
