package students.suppliers;

import students.addition.random.NameRandomGenerator;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RusRandomNameFromFileSupplier implements Supplier<String> {
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    @Override
    public String get() {
        NameRandomGenerator nameGenerator = null;
        try {
            nameGenerator = new NameRandomGenerator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert nameGenerator != null;
        return nameGenerator.getRandomName();
    }
}
