package ho.artisan.azusaconfig.neoforge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.impl.AzusaConfigImpl;
import net.neoforged.fml.common.Mod;

@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModNeoForge {
    public AzusaConfigModNeoForge() {
        AzusaConfigImpl.init();
    }
}
