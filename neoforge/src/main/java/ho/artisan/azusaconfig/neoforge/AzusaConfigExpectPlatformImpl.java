package ho.artisan.azusaconfig.neoforge;

import ho.artisan.azusaconfig.neoforge.impl.entrypoint.EntrypointStorage;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.List;

public class AzusaConfigExpectPlatformImpl {
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static <T> List<T> getEntrypoints(String key, Class<T> type) {
        return (List<T>) EntrypointStorage.getEntrypointContainers(key, type);
    }
}
