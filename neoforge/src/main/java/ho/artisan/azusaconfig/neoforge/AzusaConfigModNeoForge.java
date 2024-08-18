package ho.artisan.azusaconfig.neoforge;

import ho.artisan.azusaconfig.AzusaConfigMod;
import ho.artisan.azusaconfig.impl.AzusaConfigImpl;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;

@Mod(AzusaConfigMod.MOD_ID)
public class AzusaConfigModNeoForge {

    public AzusaConfigModNeoForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IExtensionPoint.DisplayTest.IGNORESERVERONLY, (a, b) -> true));
        AzusaConfigImpl.init();
    }
}
