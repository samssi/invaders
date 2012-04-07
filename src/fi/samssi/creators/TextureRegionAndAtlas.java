package fi.samssi.creators;

import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class TextureRegionAndAtlas {
    private final BitmapTextureAtlas spaceInvaderAtlas;
    private final TextureRegion spaceInvaderTextureRegion;

    public TextureRegionAndAtlas(final BitmapTextureAtlas spaceInvaderAtlas, final TextureRegion spaceInvaderTextureRegion) {
        this.spaceInvaderAtlas = spaceInvaderAtlas;
        this.spaceInvaderTextureRegion = spaceInvaderTextureRegion;
    }

    public BitmapTextureAtlas getSpaceInvaderAtlas() {
        return spaceInvaderAtlas;
    }

    public TextureRegion getSpaceInvaderTextureRegion() {
        return spaceInvaderTextureRegion;
    }
}
