package ext;

import objsize.Obj;

public class Test {
   static   class Animal{
        private int age ;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
  static   class Dog extends Animal{
        private int age = 11;

        @Override
        public int getAge() {
            return super.getAge();
        }

        @Override
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Object o =(Object)dog ;
        System.out.println(dog.getAge());

    }
}
