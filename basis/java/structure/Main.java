package structure;

public class Main {
    public static void main(String[] args) {


        // 不能直接 new 一个接口类型或抽象类；只能通过“具体的（concrete）类”来创建对象（即 new 某个非抽象类的实例）
        Person student = new Student("Bob", "Smith", 55);
        // MathTeacher 是一个 concrete 类，它继承了 Teacher 并实现了剩余的抽象方法
        Teacher mathT = new MathTeacher("Charles", 40);
        // 或者也可以用接口类型来引用：
        Person mathPerson = new MathTeacher("Diana", 35);



        Student s = new Student("Alice", "Williams", 20);
        s.speak();                   // 调用实例方法
        System.out.println(s.getName());

        Person.info();               // 调用接口静态方法
        Student.info();              // 调用类静态方法


        // Teacher 是抽象类，不能直接创建实例
        // Teacher t = new Teacher("Emily", 28); // ❌ 错误！


        MathTeacher t = new MathTeacher("Charles", 40);
        System.out.println(t.getName());
        MathTeacher.info();


    }
}
