package fi.samssi.container;

import java.util.HashMap;

import fi.samssi.creators.Atlas;

public class HashMapAtlasContainer<T> {
    private final HashMap<Atlas, T> textures = new HashMap<Atlas, T>();

    public void add(final Atlas region, final T textureRegionAndAtlas) {
        if (textures.containsKey(region)) {
            throw new RuntimeException("Double textureregion. Storing texture regions failed!");
        }
        textures.put(region, textureRegionAndAtlas);
    }

    public T get(final Atlas region) {
        return textures.get(region);
    }

}
