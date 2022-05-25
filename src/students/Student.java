package students;

import students.addition.random.RandomStudentGenerator;

import java.io.IOException;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final int number;
    private String name;
    private int age;
    private double mark;
    private boolean isOlimpiadaMember;

    public Student(int number) throws IOException {
        this.number = number;
        this.name = RandomStudentGenerator.getRandomName();
        this.age = RandomStudentGenerator.getRandomAge();
        this.mark = RandomStudentGenerator.getRandomMark();
        this.isOlimpiadaMember = RandomStudentGenerator.getRandomIsOlimpiadaMember();
    }

    public Student(int number, String[] names){
        this.number = number;
        this.name = RandomStudentGenerator.getRandomName(names);
        this.age = RandomStudentGenerator.getRandomAge();
        this.mark = RandomStudentGenerator.getRandomMark();
        this.isOlimpiadaMember = RandomStudentGenerator.getRandomIsOlimpiadaMember();
    }

    public Student(int number, char startCharacter){
        this.number = number;
        this.name = RandomStudentGenerator.getRandomName(startCharacter);
        this.age = RandomStudentGenerator.getRandomAge();
        this.mark = RandomStudentGenerator.getRandomMark();
        this.isOlimpiadaMember = RandomStudentGenerator.getRandomIsOlimpiadaMember();
    }


    public Student(int number, String name, int age, double mark, boolean isOlimpiadaMember) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.mark = mark;
        this.isOlimpiadaMember = isOlimpiadaMember;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getMark() {
        return this.mark;
    }

    public boolean isOlimpiadaMember() {
        return this.isOlimpiadaMember;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setOlimpiadaMember(boolean olimpiadaMember) {
        isOlimpiadaMember = olimpiadaMember;
    }

    @Override
    public String toString() {
        String info = "№ п.п.: " + number +
                "; имя: '" + name +
                "; возраст: " + age +
                "; оценка: " + mark +
                "; участник олимпиад: ";
        info += (isOlimpiadaMember ? "да" : "нет");
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number && age == student.age && Double.compare(student.mark, mark) == 0
                && isOlimpiadaMember == student.isOlimpiadaMember && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, age, mark, isOlimpiadaMember);
    }

    @Override
    public int compareTo(Student another) {
        return getName().compareTo(another.getName());
    }
}
