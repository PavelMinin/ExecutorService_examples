package students.suppliers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RusNameFromArraySupplier implements Supplier<String> {
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();
    private static final String[] names = {
            "Авдей",
            "Авксентий",
            "Агапит",
            "Агафон",
            "Акакий",
            "Александр",
            "Алексей",
            "Альберт",
            "Альвиан",
            "Анатолий",
            "Андрей",
            "Аникита",
            "Антон",
            "Антонин",
            "Анфим",
            "Аристарх",
            "Аркадий",
            "Арсений",
            "Артём",
            "Артемий",
            "Артур",
            "Архипп",
            "Афанасий",
    };

    @Override
    public String get() {
        return names[rnd.nextInt(0,names.length)];
    }
}
