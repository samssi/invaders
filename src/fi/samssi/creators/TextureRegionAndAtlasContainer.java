package fi.samssi.creators;

import java.util.HashMap;

public class TextureRegionAndAtlasContainer {
    private final HashMap<Atlas, TextureRegionAndAtlas> textures = new HashMap<Atlas, TextureRegionAndAtlas>();

    public void add(final Atlas region, final TextureRegionAndAtlas textureRegionAndAtlas) {
        if (textures.containsKey(region)) {
            throw new RuntimeException("Double textureregion. Storing texture regions failed!");
        }
        textures.put(region, textureRegionAndAtlas);
    }

    public TextureRegionAndAtlas get(final Atlas region) {
        return textures.get(region);
    }

}
