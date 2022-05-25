package students.suppliers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class StringFromArraySupplier implements Supplier<String> {
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();
    private final String[] strings;

    public StringFromArraySupplier(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String get() {
        return strings[rnd.nextInt(0,strings.length)];
    }
}
