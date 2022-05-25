package students.predicate;

import students.Student;

import java.util.function.Predicate;

public class StudentMarkGreat implements Predicate<Student> {
    private final double mark;

    public StudentMarkGreat(double mark) {
        this.mark = mark;
    }

    @Override
    public boolean test(Student item) {
        return item.getMark() > mark;
    }
}
