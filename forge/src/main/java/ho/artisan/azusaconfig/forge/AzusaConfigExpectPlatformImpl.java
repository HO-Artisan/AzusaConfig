package ho.artisan.azusaconfig.forge;

import ho.artisan.azusaconfig.forge.impl.entrypoint.EntrypointStorage;
import net.minecraftforge.fml.loading.FMLPaths;


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
