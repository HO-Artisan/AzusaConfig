package ho.artisan.examplemod.neoforge;

import ho.artisan.examplemod.ExampleExpectPlatform;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ExampleExpectPlatformImpl {
    /**
     * This is our actual method to {@link ExampleExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
