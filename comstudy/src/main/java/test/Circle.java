package test;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("the circle is drawing....");
    }

    @Override
    public void erase() {
        System.out.println("the circle is erasing....");
    }


    public static class Factory extends ShapeFactory{

        @Override
        protected Shape create() {
            return new Circle();
        }

        static {
            ShapeFactory.addFactory("Circle", new Factory());
        }
    }

    public static void main(String[] args) {
        System.out.println(Factory.class);
    }
}
