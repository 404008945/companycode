public class Test {
    public static Test test;
    public void isAlive() {
        System.out.println("I am alive :)");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        test = this; //增加引用
    }
    public static void main(String[] args)throws Exception {
        //  Test.class  class也是一个对象
        test = new Test();
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("no,I am dead :(");
        }
        // 下面代码与上面完全一致，但是此次自救失败
        // ，任何一个对象的ﬁnalize()方法都只会被系统自动调用一次
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("no,I am dead :(");
        }
    }
}
