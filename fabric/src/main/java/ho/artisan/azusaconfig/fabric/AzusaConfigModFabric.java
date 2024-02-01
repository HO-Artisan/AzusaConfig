package ho.artisan.azusaconfig.fabric;

import ho.artisan.azusaconfig.AzusaConfigMod;
import net.fabricmc.api.ModInitializer;

public class AzusaConfigModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AzusaConfigMod.init();
    }
}
