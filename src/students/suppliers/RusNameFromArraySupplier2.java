package students.suppliers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RusNameFromArraySupplier2 implements Supplier<String> {

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

    private final Supplier<String> namesSupplier;

    public RusNameFromArraySupplier2() {
        this.namesSupplier = new StringFromArraySupplier(names);
    }

    @Override
    public String get() {
        return namesSupplier.get();
    }
}
