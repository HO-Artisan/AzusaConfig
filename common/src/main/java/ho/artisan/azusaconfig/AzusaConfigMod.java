package ho.artisan.azusaconfig;

import ho.artisan.azusaconfig.impl.config.AzusaConfigImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class AzusaConfigMod {
    public static final String MOD_ID = "azusa_config";
    public static final String MOD_NAME = "AzusaConfig";


    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final Marker MARKER = MarkerFactory.getMarker("Config");
    
    public static void init() {
        AzusaConfigImpl.init();
    }
}
