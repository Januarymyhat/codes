package structure;

public interface Person {
    int MAX_AGE = 150;  // 等价于 public static final int MAX_AGE = 150;

    // ==================   抽象方法（必须由实现类实现）
    void speak();
    // 等价于：
    // 写法2：显式写法（效果相同）
    // public abstract void speak();
    // 写法3：混合写法（效果相同）
    // abstract void speak();
    
    String getName();
    void printAge(int a);


    // ==================   静态方法（只能通过接口名调用）
    static void info() {
        System.out.println("I am a Person interface");
    }


    // ==================   默认方法：有默认实现，子类可以选择覆盖
    default String getDescription() {
        return "I am a person. My name is " + getName();
    }
}



