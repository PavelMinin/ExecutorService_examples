import students.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Job implements Callable<List<Student>> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> call() {
        try {
            studentGenerator(10_000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getThreadInfo());
        return this.students;
    }

    private void studentGenerator(int quantity) throws IOException {
        for(int i = 0; i < quantity; i++) {
            try {
                this.students.add(new Student(i + 1));
            } catch(IOException e) {
                throw new IOException("Ошибка чтения файла");
            }
        }
    }

    private String getThreadInfo() {
        StringBuilder sb = new StringBuilder("Thread name: ").append(Thread.currentThread().getName()).append("\n")
                .append("Thread id: ").append(Thread.currentThread().getId()).append("\n")
                .append("Thread state: ").append(Thread.currentThread().getState());
        return sb.toString();
    }
}
