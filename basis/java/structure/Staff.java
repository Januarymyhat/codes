package structure;

// Record：简洁数据类，自动生成构造器和访问器，字段默认 final
public record Staff(String name, int age) implements Person{

    // record 自动生成：
    // 1. 构造函数
    // 2. getter 方法（name() 和 age()）
    // 3. toString(), equals(), hashCode()

    @Override
    public void speak() {
        System.out.println("Hello, I am a student. My name is " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printAge(int a) {
        System.out.println("Given age is: " + a);
    }
}
