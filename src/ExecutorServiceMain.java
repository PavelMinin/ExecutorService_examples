import students.Student;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        Job job1 = new Job();
        Job job2 = new Job();
        Job job3 = new Job();
        Job job4 = new Job();

        long start = System.currentTimeMillis();
        job1.call();
        job2.call();
        job3.call();
        job4.call();
        long stop = System.currentTimeMillis();

        double mainThreadTime = (stop - start)/1_000.;
        System.out.println("Время выполнения четырех поочередных операций: " +
                mainThreadTime + " c");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        start = System.currentTimeMillis();
        Future<List<Student>> future1 = executor.submit(job1);
        Future<List<Student>> future2 = executor.submit(job1);
        Future<List<Student>> future3 = executor.submit(job1);
        Future<List<Student>> future4 = executor.submit(job1);
        try {
            future1.get();
            future2.get();
            future3.get();
            future4.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();

        executor.shutdown();

            System.out.println("Время выполнения четырех операций пулом потоков с фиксированным числом 2: " +
                    ((stop - start)/1_000.) + " c");
    }
}
