package ho.artisan.azusaconfig;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;
import java.util.List;

public class AzusaConfigExpectPlatform {
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T> List<T> getEntrypoints(String key, Class<T> type) {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
