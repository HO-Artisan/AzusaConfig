package ho.artisan.azusaconfig.neoforge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.neoforge.impl.entrypoint.EntrypointStorage;
import net.neoforged.fml.common.Mod;

@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModNeoForge {
    public AzusaConfigModNeoForge() {
        EntrypointStorage.loadAll();
        AzusaConfigMod.init();
    }
}
