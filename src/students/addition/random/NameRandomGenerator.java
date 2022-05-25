package students.addition.random;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NameRandomGenerator {
    private final String[] names;
    private final String[] lastNames;
    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    /**
     * Конструктор запускает чтение файлов.
     * @throws IOException
     */
    public NameRandomGenerator() throws IOException {
        this.names = readFile("rus_names.txt");
        this.lastNames = readFile("rus_last_names.txt");
    }

    /**
     * Метод возвращает комбинацию случайной фамилии и имени.
     * @return строка с именем и фамилией, разделенные пробелом
     */
    public String getRandomName() {
        return getRandomLastName() + " " + getRandomFirstName();
    }

    /**
     * Метод считывает файл с передаваемым именем из директории src/students/resources.
     * Изначальный объем массива 50 ячеек. При переполнении, объем увеличивается в 1,5 раза.
     * @param fileName имя файла для чтения
     * @return массив строк, считанных из файла
     * @throws IOException
     */
    private String[] readFile(String fileName) throws IOException {
        Path path = Paths.get("/Users/pavelminin/IdeaProjects/Md-JC1/homework/src/students/resources", fileName);
        Scanner scanner = new Scanner(path);

        String[] strArray = new String[50];
        int count = 0;
        while(scanner.hasNextLine()) {
            if(strArray[strArray.length - 1] != null) {
                String[] tmp = new String[strArray.length * 3 / 2];
                System.arraycopy(strArray, 0, tmp, 0, strArray.length);
                strArray = tmp;
            }
            strArray[count] = scanner.nextLine();
            count++;
        }
        return strArray;
    }

    /**
     * Возвращает случайное значение из массива имен. Проводится проверка на null.
     * @return строку со случайным именем из списка.
     */
    private String getRandomFirstName() {
        String firstName;
        do {
            firstName = this.names[rnd.nextInt(0, this.names.length)];
        } while (firstName == null);
        return firstName;
    }

    /**
     * Возвращает случайное значение из массива фамилий. Проводится проверка на null.
     * @return строку со случайной фамилией из списка.
     */
    private String getRandomLastName() {
        String lastName;
        do {
            lastName = this.lastNames[rnd.nextInt(0, this.lastNames.length)];
        } while (lastName == null);
        return lastName;
    }
}
