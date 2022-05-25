package students;

import students.addition.comparators.AgeComparator;
import students.addition.comparators.MarkComparator;
import students.addition.comparators.NameComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentsMain3 extends StudentsMain1 {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>(10_000);

        for(int i = 0; i < 10_000; i++) {
            students.add(new Student(i));
        }

        List<Student> filteredStudents = getFilteredStudents(students, 12, 8);

        double averageAge = Math.ceil(getAverageAge(filteredStudents) * 10) / 10;
        System.out.println("\nСредний возраст отфильтрованных студентов: " + averageAge + "\n");

        filteredStudents.sort(new NameComparator());
        System.out.println("\nТоп-10 сортировка по имени (возраставние):\n");
        printTopTen(filteredStudents);

        filteredStudents.sort(new MarkComparator().reversed());
        System.out.println("\nТоп-10 сортировка по оценке (убывание):\n");
        printTopTen(filteredStudents);

        filteredStudents.sort(new AgeComparator().thenComparing(new MarkComparator().reversed()));
        System.out.println("\nТоп-10 сортировка по оценке (убывание) для каждого возраста:\n");
        printForEachAge(filteredStudents);
    }
}
