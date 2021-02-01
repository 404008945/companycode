package objsize;

public class Outer {
    int x = 9;
    class Inner{
        int x = 8;
        public void test(){
            int x = 7;
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
            test1();
        }
    }

    private void test1(){
        System.out.println("test");
    }
    public static void main(String[] args) {
        Inner in = new Outer().new Inner();
        in.test();
    }
}