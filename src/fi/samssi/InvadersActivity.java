package fi.samssi;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import fi.samssi.creators.TextureRegionAndAtlasCreator;
import fi.samssi.creators.GameEngineCreator;
import fi.samssi.creators.SceneCreator;
import fi.samssi.creators.TextureRegionAndAtlas;
import fi.samssi.creatures.Invader;

public class InvadersActivity extends BaseGameActivity {
    private final ZoomCamera zoomCamera = new ZoomCamera(0, 0, GameEngineCreator.DEFAULT_CAMERA_WIDTH, GameEngineCreator.DEFAULT_CAMERA_HEIGHT);
    private final Engine engine = new GameEngineCreator().createGameEngineWith(zoomCamera);
    //    private final Scene scene = new SceneCreator().createSceneWith(engine);
    private final float x = 100f;
    private final float y = 200f;
    private final TextureRegionAndAtlasCreator textureRegionAndAtlasCreator = new TextureRegionAndAtlasCreator(this);
    private TextureRegionAndAtlas spaceInvaderTextureRegionAndAtlas;
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
        spaceInvaderTextureRegionAndAtlas = textureRegionAndAtlasCreator.createSpaceInvaderAtlas();
        engine.getTextureManager().loadTexture(spaceInvaderTextureRegionAndAtlas.getSpaceInvaderAtlas());
    }

    @Override
    public Scene onLoadScene() {
        engine.registerUpdateHandler(new FPSLogger());
        invader1 = new Invader(0, 0, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        invader2 = new Invader(0, 100, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        invader3 = new Invader(0, 200, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        invader4 = new Invader(100, 0, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        invader5 = new Invader(100, 100, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        invader6 = new Invader(x, y, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        return new SceneCreator().createSceneWith(invader1, invader2, invader3, invader4, invader5, invader6);
    }

    @Override
    public void onLoadComplete() {
    }

}