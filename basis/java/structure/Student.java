package structure;

// 具体类，实现接口的所有方法
public class Student implements Person {
    // ==================   Members  ==================  

    // ==================   Filed
    private String firstName;
    private String lastName;
    private int age;


    // ==================   Constructor: 永远都不能声明为 static；静态方法 != 构造函数
    public Student(String firstname, String lastname, int age) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
    }

    public Student(String firstName, String lastName){
        // Java 会 跳到同一个类中“匹配签名为 (String, String, int) 的构造函数”去执行
        this(firstName, lastName, 0);
    }

    public Student(){
        // 更严谨
        this("Unknown", "Unkonwn", 0); 
        // 👆👇 这两种写法不等价
        // this.firstName = "Unkonwn"; 
        // this.lastName = "Unknown";
        // this.age = 0;
    }



    // ==================   Method
    @Override
    public void speak() {
        System.out.println("Hello, I am a student. My name is " + firstName + " " + lastName);
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public void printAge(int age) {
        System.out.println("Given age is: " + age);
    }

    public int getAge() {
        return age;
    }
    // 接口静态方法不会被子类覆盖
    static void info() {
        System.out.println("I am a Student class");
    }
    // Person.info();   // 调用接口静态方法
    // Student.info();  // 调用类的静态方法

    // ==================   Members  ==================  
}

