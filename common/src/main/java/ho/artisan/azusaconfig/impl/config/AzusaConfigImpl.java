/*
 * Copyright 2022, 2023 QuiltMC
 * Copyright 2024 HO-Artisan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ho.artisan.azusaconfig.impl.config;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import ho.artisan.azusaconfig.AzusaConfigExpectPlatform;
import ho.artisan.azusaconfig.AzusaConfigMod;
import org.quiltmc.config.api.ConfigEnvironment;
import org.quiltmc.config.api.Serializer;
import org.quiltmc.config.api.serializers.Json5Serializer;
import org.quiltmc.config.api.serializers.TomlSerializer;
import org.slf4j.Logger;

public final class AzusaConfigImpl {
    private static ConfigEnvironment ENV;
    private static final Path CONFIG_DIR = AzusaConfigExpectPlatform.getConfigDirectory();
    private static final Logger LOGGER = AzusaConfigMod.LOGGER;

    private AzusaConfigImpl() {
    }

    public static void init() {
        Map<String, Serializer> serializerMap = new LinkedHashMap<>();

        serializerMap.put("toml", TomlSerializer.INSTANCE);
        serializerMap.put("json5", Json5Serializer.INSTANCE);

        for (Serializer serializer : AzusaConfigExpectPlatform.getEntrypoints("config_serializer", Serializer.class)) {
            Serializer oldValue = serializerMap.put(serializer.getFileExtension(), serializer);

            if (oldValue != null) {
                LOGGER.warn(AzusaConfigMod.MARKER, "Replacing {} serializer {} with {}", serializer.getFileExtension(), oldValue.getClass(), serializer.getClass());
            }
        }

        String globalConfigExtension = System.getProperty("azusaconfig.globalConfigExtension");
        String defaultConfigExtension = System.getProperty("azusaconfig.defaultConfigExtension");

        Serializer[] serializers = serializerMap.values().toArray(new Serializer[0]);

        if (globalConfigExtension != null && !serializerMap.containsKey(globalConfigExtension)) {
            throw new RuntimeException("Cannot use file extension " + globalConfigExtension + " globally: no matching serializer found");
        }

        if (defaultConfigExtension != null && !serializerMap.containsKey(defaultConfigExtension)) {
            throw new RuntimeException("Cannot use file extension " + defaultConfigExtension + " by default: no matching serializer found");
        }

        if (defaultConfigExtension == null) {
            ENV = new ConfigEnvironment(CONFIG_DIR, globalConfigExtension, serializers[0]);

            for (int i = 1; i < serializers.length; ++i) {
                ENV.registerSerializer(serializers[i]);
            }
        } else {
            ENV = new ConfigEnvironment(CONFIG_DIR, globalConfigExtension, serializerMap.get(defaultConfigExtension));

            for (Serializer serializer : serializers) {
                ENV.registerSerializer(serializer);
            }
        }
    }

    public static ConfigEnvironment getConfigEnvironment() {
        return ENV;
    }
}