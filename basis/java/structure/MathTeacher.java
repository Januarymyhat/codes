package structure;

// MathTeacher：具体子类，补全剩余抽象方法
public class MathTeacher extends Teacher{
    public MathTeacher(String name, int age) {
        super(name, age); // 属于 Teacher
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void printAge(int a) {  // 这里的 age 并不是 Teacher 里的 private int age
        System.out.println("Given age is: " + a);
    }

    @Override
    public String getDescription() {
        return "This is a modified description";
    }

    static void info() {
        System.out.println("I am a MathTeacher class");
    }
}