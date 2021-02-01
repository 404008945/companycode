public class Dog {
    private int age ;
    ThreadLocal threadLocal = new ThreadLocal();
   static   class SmallDog extends Dog {

    }


    public static void main(String[] args) {

        SmallDog smallDog = new SmallDog();
        System.out.println(smallDog.getClass());

        Dog d = smallDog;

        System.out.println(d.getClass());
    }
}
