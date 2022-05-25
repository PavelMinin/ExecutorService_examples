package students.suppliers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RusNameFromRandomCharacterSupplier implements Supplier<String> {
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();


    @Override
    public String get() {
        int nameLength = rnd.nextInt(3,11);
        StringBuilder sb = new StringBuilder();
        sb.append((char) rnd.nextInt(1040,1072));
        for(int j = 1; j <= nameLength; j++){
            sb.append((char) rnd.nextInt(1072,1103));
        }

        return sb.toString();
    }
}
