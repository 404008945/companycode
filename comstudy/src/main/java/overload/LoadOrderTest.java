package overload;

import lombok.Data;

@Data
public class LoadOrderTest {
    LoadOrderTest(int v){
        System.out.println("hello");
    //    this.a = v;
    }
    private int a = 10;
    {
       a=get();
        System.out.println("a赋值完毕");
    }
    {
        System.out.println("b初始化");
    }
   final   private int b=180;
    {
        System.out.println("b初始化结束");
    }
    int get(){
        int c;
        return b;
    }

    public static void main(String[] args) {
        LoadOrderTest test = new LoadOrderTest(111);
        System.out.println(test.getA());
    }
}
