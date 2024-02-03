package ho.artisan.azusaconfig.forge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.forge.impl.entrypoint.EntrypointStorage;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;

@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModForge {
    public AzusaConfigModForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        EntrypointStorage.loadAll();
        AzusaConfigMod.init();
    }
}
