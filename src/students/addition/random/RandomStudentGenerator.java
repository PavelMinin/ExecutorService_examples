package students.addition.random;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStudentGenerator {
    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    /**
     * Генерирует рандоиное имя используя NameRandomGenerator
     * @return строку с именем и фамилией.
     * @throws IOException
     */
    public static String getRandomName() throws IOException {
        NameRandomGenerator nameGenerator = new NameRandomGenerator();
        return nameGenerator.getRandomName();
    }

    /**
     * Генерирует рандоиное имя используя выбирая случайный элемент из предоставленного массива имен.
     * @return случайная строка из исходного массива строк.
     * @throws IOException
     */
    public static String getRandomName(String[] names) {
            return names[rnd.nextInt(0,names.length)];
    }
    /**
     * Генерирует случайное имя из массива символов алфавита русскай кирилицы.
     * Первая буква большая, остальные малые.
     * @return строка состоящая из набора рандомных символов кирилиицы длиной от 3 до 10 символов, начинающаяся с заглавной.
     * @throws IOException
     */
    public static String getRandomName(char StartCharacter) {
        int nameLength = rnd.nextInt(3,11);
        String name = "";
        name += (char) rnd.nextInt(StartCharacter,1072);
        for(int j = 1; j <= nameLength; j++){
            name += (char) rnd.nextInt(1072,1103);
        }
        return name;
    }

    /**
     * Генерирует случайное значение возраста от 7 до 17 лет.
     * @return целочисленное значение возраста от 7 до 17 лет.
     */
    public static int getRandomAge() {
        return rnd.nextInt(7, 18);
    }

    /**
     * Генерирует случайное значение оценки от 0 до 10.
     * Округляет до десятых.
     * @return значение оценки от 0.0 до 10.0.
     */
    public static double getRandomMark() {
        double tmp = rnd.nextFloat();
        tmp = Math.ceil(tmp * 100) / 10;
        return tmp;
    }

    /**
     * Генерирует флаг участия в олимпиаде. ~20% являются участниками.
     * @return true -  является, false - не является.
     */
    public static boolean getRandomIsOlimpiadaMember() {
        double tmp = rnd.nextInt(0, 101);
        return tmp >= 80;
    }
}
