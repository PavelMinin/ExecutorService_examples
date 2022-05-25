package students.predicate;

import students.Student;

import java.util.function.Predicate;

public class StudentAgeGreatAndEqual implements Predicate<Student> {
    private final int age;

    public StudentAgeGreatAndEqual(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Student item) {
        return item.getAge() >= age;
    }
}
