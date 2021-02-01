package inner;

public class MemInner {
    int num = 10;
    String s="";
    public static void main(String[] args) {
        MemInner mi = new MemInner();
        Inner in = mi.new Inner();
        System.out.println(in.num);
        in.systemOut();
    }
    public class Inner{
        int num = 9;
        public void systemOut(){
            System.out.println(num);
            System.out.println(MemInner.this.num);
            s.length();
        }
    }

}
