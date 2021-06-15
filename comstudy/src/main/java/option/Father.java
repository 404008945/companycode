package option;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Father {
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   static   class Son extends Father{

        public int getPId() {
            return super.getId();
        }

        @Override
        public int getId() {
            return super.getId();
        }

        @Override
        public void setId(int id) {
           super.setId(id);
        }
    }

    public static void main(String[] args) {
        Supplier<ArrayList<Integer>> supplier = ()->new ArrayList<>();
      List<Integer> list =  supplier.get();
        System.out.println(list);
    }

    static <T> T test(Supplier<T> supplier) {
        return supplier.get();
    }
}
