package option;

public class ClassB {
    String id;
    String nickName;

    public ClassB(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "ClassB{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }
}
