package fi.samssi.creators;

import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.content.Context;

public class TextureRegionAndAtlasCreator {
    private final Context context;

    public TextureRegionAndAtlasCreator(final Context context) {
        this.context = context;
    }

    public TextureRegionAndAtlas createSpaceInvaderAtlas() {
        BitmapTextureAtlas spaceInvaderAtlas = new BitmapTextureAtlas(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        TextureRegion spaceInvaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(spaceInvaderAtlas, context, "space_invader_small.png", 0, 0);
        return new TextureRegionAndAtlas(spaceInvaderAtlas, spaceInvaderTextureRegion);
    }

    public TextureRegionAndAtlas createSpaceShipAtlas() {
        BitmapTextureAtlas spaceInvaderAtlas = new BitmapTextureAtlas(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        TextureRegion spaceInvaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(spaceInvaderAtlas, context, "space_ship_small.png", 0, 0);
        return new TextureRegionAndAtlas(spaceInvaderAtlas, spaceInvaderTextureRegion);
    }

    public TextureRegionAndAtlas createShotAtlas() {
        BitmapTextureAtlas spaceInvaderAtlas = new BitmapTextureAtlas(16, 16, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        TextureRegion spaceInvaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(spaceInvaderAtlas, context, "shot.png", 0, 0);
        return new TextureRegionAndAtlas(spaceInvaderAtlas, spaceInvaderTextureRegion);
    }


}
