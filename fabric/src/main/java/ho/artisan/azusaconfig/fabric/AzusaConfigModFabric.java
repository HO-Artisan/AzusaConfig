package ho.artisan.azusaconfig.fabric;

import ho.artisan.azusaconfig.impl.config.AzusaConfigImpl;
import net.fabricmc.api.ModInitializer;

public class AzusaConfigModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AzusaConfigImpl.init();
    }
}
