package structure;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", "Williams", 20);
        s.speak();                   // 调用实例方法
        System.out.println(s.getName());

        Person.info();               // 调用接口静态方法
        Student.info();              // 调用类静态方法
    }
}
