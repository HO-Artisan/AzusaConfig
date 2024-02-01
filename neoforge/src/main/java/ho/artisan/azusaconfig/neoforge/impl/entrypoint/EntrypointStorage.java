/*
 * Copyright (C) 2023 TT432
 * Copyright (C) 2024 TexTrue
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ho.artisan.azusaconfig.neoforge.impl.entrypoint;

import ho.artisan.azusaconfig.neoforge.api.entrypoint.EntrypointContainer;
import ho.artisan.azusaconfig.neoforge.api.entrypoint.EntrypointLoadingException;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IConfigurable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EntrypointStorage {
    private static boolean init;
    private static final Map<String, List<EntrypointContainer<Object>>> map = new HashMap<>();

    public static void loadAll() {
        if (!init) {
            ModList.get().forEachModFile(mf -> {
                IConfigurable config = mf.getModFileInfo().getConfig();
                List<? extends IConfigurable> mods = config.getConfigList("mods");
                IConfigurable modEntry = mods.get(0);
                Object modName = modEntry.getConfigElement("displayName").orElse("<unnamed>");
                Object modId = modEntry.getConfigElement("modId").orElse("<unnamed>");

                config.<Map<String, List<Object>>>getConfigElement("entrypoints")
                        .orElse(new HashMap<>())
                        .forEach((k, v) -> map.put(k, v.stream().map(Object::toString)
                                .map(s -> {
                                    try {
                                        return Class.forName(s).getDeclaredConstructor().newInstance();
                                    } catch (InstantiationException | IllegalAccessException |
                                             InvocationTargetException | NoSuchMethodException |
                                             ClassNotFoundException e) {
                                        throw new EntrypointLoadingException(
                                                "can't load %s by mod %s (%s)".formatted(s, modName, modId), e);
                                    }
                                })
                                .map(o -> new EntrypointContainer<Object>(o, mf)).toList()));
            });
        }
    }

    /**
     * Try to get all EntrypointContainer with key as key and convert to type
     *
     * @param key  key
     * @param type witch cast
     * @param <T>  t
     * @return list of container
     */
    public static <T> List<EntrypointContainer<T>> getEntrypointContainers(String key, Class<T> type) {
        loadAll();

        return map.computeIfAbsent(key, s -> new ArrayList<>()).stream().map(ec -> {
            try {
                type.cast(ec.entrypoint());
                return (EntrypointContainer<T>) ec;
            } catch (ClassCastException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
