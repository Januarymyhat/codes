package structure;

// 抽象类，可以只实现部分接口方法
// 不能被实例化，也就是不能直接 new Teacher(...)
public abstract class Teacher implements Person {
    // 这里如果不加final 无法保证getName()等 能返回确定的值
    protected final String name;
    private final int age;

    // final = 一次性赋值，永不改变
    private final String species = "Human";  // 每个Teacher对象都有自己的"Human"

    public Teacher(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @Override
    public void speak() {
        System.out.println("Hello, I am a teacher. My name is " + name
                            + ". I am a " + species);
    }
    // getName() 和 printAge() 暂时没写 → Teacher 仍然是抽象类

    public int getAge() {
        return age;
    }

    // 可以不重写getDescription()，使用接口的默认实现

}