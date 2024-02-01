package ho.artisan.examplemod.fabric;

import ho.artisan.examplemod.ExampleMod;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
    }
}
