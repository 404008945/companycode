package objsize;

public class Obj {
    static int a ;
    private int age;
    private long height;
    private boolean married;
    private String name;
    private String addr;
    private String sex;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Obj(int age, long height, boolean married, String name, String addr, String sex) {
        this.age = age;
        this.height = height;
        this.married = married;
        this.name = name;
        this.addr = addr;
        this.sex = sex;
    }
}
