package inner;

public class AreaInner {
    int num = 9;
    public static void main(String[] args) {
        AreaInner ai = new AreaInner();
        ai.Inner();
    }
    public void Inner(){
        String name = "黄花大闺女";
        class AInner{
            void call(){
                System.out.println(num);
                System.out.println(name);
            }
        }
        AInner an = new AInner();
        an.call();
    }
}