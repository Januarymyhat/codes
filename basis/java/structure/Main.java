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


        /**
         * instanceof
         * 用途主要是：
         * 1. 向下转型（(SomeType) obj）前，先检查类型是否匹配
         * 2. 多态分支时，根据不同子类型做不同逻辑
         * 3. 避免 ClassCastException
         */
        System.out.println(student instanceof Person);  // 一定输出 true
        // 常见的 instanceof 用法，是用来判断一个父类型引用是否确实指向某个子类型实例，比如
        Object o = new Integer(5);
        String s = (String) o; // 会在这里抛 ClassCastException

        // 改为
        if (o instanceof String) {
            String s = (String) o;
            // ...
        } else {
            // 不是 String，就执行别的逻辑
        }

    }
}
