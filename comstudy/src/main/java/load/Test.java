package load;

public  class Test {
    static {
        i=0;  //可以赋
    }
    static int i=1;
    static class A{
        static {
            System.out.println("ss");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        int a = 128;

        Integer i3=a;

        Integer i4= Integer.valueOf(a);

        System.out.println(i3==i4);
    }
}
