package fi.samssi;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import fi.samssi.creatures.Invader;

import fi.samssi.creators.GameEngineCreator;
import fi.samssi.creators.SceneCreator;

public class InvadersActivity extends BaseGameActivity {
    private final ZoomCamera zoomCamera = new ZoomCamera(0, 0, GameEngineCreator.DEFAULT_CAMERA_WIDTH, GameEngineCreator.DEFAULT_CAMERA_HEIGHT);
    private final Engine engine = new GameEngineCreator().createGameEngineWith(zoomCamera);
    //    private final Scene scene = new SceneCreator().createSceneWith(engine);
    private BitmapTextureAtlas myBitmapTextureAtlas;
    private TextureRegion myTextureRegion;
    private final float x = 100f;
    private final float y = 200f;
    private Invader invader6;
    private Invader invader5;
    private Invader invader4;
    private Invader invader3;
    private Invader invader2;
    private Invader invader1;

    @Override
    public Engine onLoadEngine() {
        return engine;
    }


    @Override
    public void onLoadResources() {
        myBitmapTextureAtlas = new BitmapTextureAtlas(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        myTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(myBitmapTextureAtlas, this, "space_invader_small.png", 0, 0);
        engine.getTextureManager().loadTexture(myBitmapTextureAtlas);
    }

    @Override
    public Scene onLoadScene() {
        engine.registerUpdateHandler(new FPSLogger());
        invader1 = new Invader(0, 0, myTextureRegion);
        invader2 = new Invader(0, 100, myTextureRegion);
        invader3 = new Invader(0, 200, myTextureRegion);
        invader4 = new Invader(100, 0, myTextureRegion);
        invader5 = new Invader(100, 100, myTextureRegion);
        invader6 = new Invader(x, y, myTextureRegion);
        invader1.setPosition(invader1.getX() + 1f, invader1.getY());
        return new SceneCreator().createSceneWith(invader1, invader2, invader3, invader4, invader5, invader6);
    }

    @Override
    public void onLoadComplete() {
    }

}