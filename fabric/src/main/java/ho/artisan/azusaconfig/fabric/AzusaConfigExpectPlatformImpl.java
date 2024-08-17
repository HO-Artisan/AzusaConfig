package ho.artisan.azusaconfig.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;
import java.util.List;

public class AzusaConfigExpectPlatformImpl {
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static <T> List<T> getEntrypoints(String key, Class<T> type) {
        return FabricLoader.getInstance().getEntrypoints(key, type);
    }
}
