package test;

public class Test {

    public static void main(String[] args) {
        String[] ids = new String[]{"Circle","Square","Square","Circle"};
        for (String id : ids){
            Shape shape = ShapeFactory.createShape(id);
            shape.draw();
            shape.erase();
        }
    }
}
