package students;

import students.addition.comparators.AgeComparator;
import students.addition.comparators.MarkComparator;
import students.addition.comparators.NameComparator;
import students.predicate.StudentAgeGreatAndEqual;
import students.predicate.StudentMarkGreat;
import students.suppliers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentsMain4 {
    public static void main(String[] args) throws IOException {
        Supplier<Student> studentSupplier = new StudentWithNameAndIdSupplier(
                new RusRandomNameFromFileSupplier()
        );

        Predicate<Student> filter = new StudentAgeGreatAndEqual(12)
                .and(new StudentMarkGreat(8));
        job(studentSupplier, filter, new NameComparator(), new MarkComparator().reversed(),
                new AgeComparator().thenComparing(new MarkComparator().reversed()));
    }

    /**
     * Выводит в консоль первые 10 элементов списка.
     * @param data список студентов.
     */
    protected static <T> void printTopTen(List<T> data) {
        int count = 0;
        for (T item : data) {
            System.out.println(item);
            if (count >= 9) break;
            count++;
        }
    }

    /**
     * Выводит по 10 первых элементов в консоль для каждого возраста.
     * @param data список студентов.
     */
    protected static <T> void printForEachAge(List<T> data) {
        int currentAge = -1;

        if(data.get(0) instanceof Student) {
            Student tmpObj = (Student) data.get(0);
            currentAge = tmpObj.getAge();
        }

        int tmp;
        int count = 0;
        for (T item : data) {
            if(item instanceof Student) {
                Student tmpObj = (Student) item;
                tmp = tmpObj.getAge();
                if(tmp == currentAge) {
                    if(count <= 9) System.out.println(item);
                    count++;

                } else {
                    currentAge = tmp;
                    count = 1;
                    System.out.println(item);
                }
            }

        }
    }

    public static <T> void job(Supplier<T> supplier, Predicate<T> filter,
                               Comparator<T> cmp1, Comparator<T> cmp2, Comparator<T> cmp3) {

        List<T> data = new ArrayList<>(10_000);

        for(int i = 0; i < 10_000; i++) {
            data.add(supplier.get());
        }

        List<T> filtered = new ArrayList<>();

        for (T item : data) {
            if(filter.test(item)) {
                filtered.add(item);
            }
        }

        filtered.sort(cmp1);
        System.out.println("\nТоп-10 сортировка по имени (возраставние):\n");
        printTopTen(filtered);

        filtered.sort(cmp2);
        System.out.println("\nТоп-10 сортировка по оценке (убывание):\n");
        printTopTen(filtered);

        filtered.sort(cmp3);
        System.out.println("\nТоп-10 сортировка по оценке (убывание) для каждого возраста:\n");
        printForEachAge(filtered);
    }
}
