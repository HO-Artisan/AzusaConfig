package ho.artisan.azusaconfig.neoforge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.neoforge.impl.entrypoint.EntrypointStorage;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.NetworkConstants;

@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModNeoForge {
    public AzusaConfigModNeoForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        EntrypointStorage.loadAll();
        AzusaConfigMod.init();
    }
}
