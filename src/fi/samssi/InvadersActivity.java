package fi.samssi;

import static fi.samssi.creators.Atlas.INVADER;
import static fi.samssi.creators.Atlas.SHOT;
import static fi.samssi.creators.Atlas.SPACESHIP;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import fi.samssi.container.HashMapAtlasContainer;
import fi.samssi.creators.GameEngineCreator;
import fi.samssi.creators.MainGameSceneCreator;
import fi.samssi.creators.TextureRegionAndAtlas;
import fi.samssi.creators.TextureRegionAndAtlasCreator;

public class InvadersActivity extends BaseGameActivity {
    private final ZoomCamera zoomCamera = new ZoomCamera(0, 0, GameEngineCreator.DEFAULT_CAMERA_WIDTH, GameEngineCreator.DEFAULT_CAMERA_HEIGHT);
    private final Engine engine = new GameEngineCreator().createGameEngineWith(zoomCamera);
    //    private final Scene scene = new SceneCreator().createSceneWith(engine);
    private final TextureRegionAndAtlasCreator textureRegionAndAtlasCreator = new TextureRegionAndAtlasCreator(this);
    private TextureRegionAndAtlas spaceInvaderTextureRegionAndAtlas;
    private TextureRegionAndAtlas spaceShipTextureRegionAndAtlas;
    private TextureRegionAndAtlas shotTextureRegionAndAtlas;
    private final HashMapAtlasContainer<TextureRegionAndAtlas> textureRegionAndAtlasContainer = new HashMapAtlasContainer<TextureRegionAndAtlas>();

    @Override
    public Engine onLoadEngine() {
        return engine;
    }


    @Override
    public void onLoadResources() {
        final TextureManager textureManager = engine.getTextureManager();
        spaceInvaderTextureRegionAndAtlas = textureRegionAndAtlasCreator.createSpaceInvaderAtlas();
        textureManager.loadTexture(spaceInvaderTextureRegionAndAtlas.getSpaceInvaderAtlas());
        textureRegionAndAtlasContainer.add(INVADER, spaceInvaderTextureRegionAndAtlas);
        spaceShipTextureRegionAndAtlas = textureRegionAndAtlasCreator.createSpaceShipAtlas();
        textureManager.loadTexture(spaceShipTextureRegionAndAtlas.getSpaceInvaderAtlas());
        textureRegionAndAtlasContainer.add(SPACESHIP, spaceShipTextureRegionAndAtlas);
        shotTextureRegionAndAtlas = textureRegionAndAtlasCreator.createShotAtlas();
        textureManager.loadTexture(shotTextureRegionAndAtlas.getSpaceInvaderAtlas());
        textureRegionAndAtlasContainer.add(SHOT, shotTextureRegionAndAtlas);
    }

    @Override
    public Scene onLoadScene() {
        engine.registerUpdateHandler(new FPSLogger());
        return new MainGameSceneCreator(textureRegionAndAtlasContainer).createScene();
    }



    @Override
    public void onLoadComplete() {
    }
}