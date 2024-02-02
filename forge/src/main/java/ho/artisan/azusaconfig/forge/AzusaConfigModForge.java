package ho.artisan.azusaconfig.forge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.forge.impl.entrypoint.EntrypointStorage;
import net.minecraftforge.fml.common.Mod;


@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModForge {
    public AzusaConfigModForge() {
        EntrypointStorage.loadAll();
        AzusaConfigMod.init();
    }
}
