package students;

import students.addition.comparators.AgeComparator;
import students.addition.comparators.MarkComparator;
import students.addition.comparators.NameComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentsMain1 {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>(10_000);

        for(int i = 0; i < 10_000; i++) {
            students.add(new Student(i, 'А'));
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

    /**
     * Создает новый список студентов и записывает туда элементы, соответствующие критериам фильтрации.
     * @param students исходный список студентов.
     * @param minAge минимальный возраст.
     * @param minMark минимальная оценка.
     * @return ссылка на новый список студентов.
     */
    protected static List<Student> getFilteredStudents(List<Student> students, int minAge, double minMark) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getAge() >= minAge && student.getMark() > minMark) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    /**
     * Возвращает средний возраст студентов из списка.
     * @param students список для расчета среднего возраста.
     * @return згачение среднего возраста (тип double).
     */
    protected static double getAverageAge(List<Student> students) {
        double ageSum = 0;
        for (Student student : students) {
            ageSum += student.getAge();
        }
        return ageSum / students.size();
    }

    /**
     * Выводит в консоль первые 10 элементов списка.
     * @param students список студентов.
     */
    protected static void printTopTen(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            System.out.println(student);
            if (count >= 9) break;
            count++;
        }
    }

    /**
     * Выводит по 10 первых элементов в консоль для каждого возраста.
     * @param students список студентов.
     */
    protected static void printForEachAge(List<Student> students) {
        int currentAge = students.get(0).getAge();
        int tmp;
        int count = 0;
        for (Student student : students) {
            tmp = student.getAge();
            if(tmp == currentAge) {
                if(count <= 9) System.out.println(student);
                count++;

            } else {
                currentAge = tmp;
                count = 1;
                System.out.println(student);
            }
        }
    }
}
