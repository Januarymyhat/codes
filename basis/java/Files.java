
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class Files {
    public static void main(String[] args) {

        // Reading
        try (var reader = new BufferedReader(new FileReader("read.txt"))) {
            String line;

            // 注意这里的括号：先赋值，再比较
            while ((line = reader.readLine()) != null){
                String[] record = line.trim().split("\\s+");
                System.out.println(Arrays.toString(record));
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Writing
        try (var write = new BufferedWriter(new FileWriter("write.txt"))){
            write.write("Hello");
            write.newLine();
            write.write("World");

        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}