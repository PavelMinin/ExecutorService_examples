package students.suppliers;

import students.Student;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class StudentWithNameAndIdSupplier implements Supplier<Student> {
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();
    private int createCount = 0;
    private final Supplier<String> names;

    public StudentWithNameAndIdSupplier(Supplier<String> names) {
        this.names = names;
    }

    @Override
    public Student get() {
        return new Student(
                ++createCount,
                names.get(),
                rnd.nextInt(7,18),
                Math.ceil(rnd.nextDouble() * 100) / 10,
                rnd.nextInt(0, 101) >= 80
        );
    }
}
