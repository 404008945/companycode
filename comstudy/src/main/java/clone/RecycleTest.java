package clone;

import io.netty.util.Recycler;
import lombok.Data;

public class RecycleTest {
    private static final Recycler<User> userRecycler = new Recycler<User>() {
        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

    @Data
   public   static final class User {
        private String name;
        private Integer age;
        private Recycler.Handle<User> handle;

        public User(Recycler.Handle<User> handle) {
            this.handle = handle;
        }

        public void recycle() {
            handle.recycle(this);
        }
    }

    public static void main(String[] args) {

        User u = userRecycler.get();
        u.setName("ss");
        u.recycle();
        User u1 = userRecycler.get();
    }
}
