package string;


    public class Test {
        Test(){
            int a = 1/0;
            return;
        }
        public static void main(String[] args) {
         Test t =  null;
         try {
             t= new Test();
         }catch (Exception e){

         }

            String s1 = new String("1");
            s1.intern();
            String s2 = "1";
            System.out.println(s1 == s2);

            String s3 = new String("1") + new String("11");//运行常量池已经有 “1”
            s3.intern();
            String s4 = "111";
            System.out.println(s3 == s4);
        }
    }

