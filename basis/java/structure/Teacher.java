package structure;

// 抽象类，可以只实现部分接口方法
public abstract class Teacher implements Person {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @Override
    public void speak() {
        System.out.println("Hello, I am a teacher. My name is " + name);
    }
    // getName() 和 printAge() 暂时没写 → Teacher 仍然是抽象类

    public int getAge() {
        return age;
    }

}