package fi.samssi;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import fi.samssi.creators.GameEngineCreator;
import fi.samssi.creators.SceneCreator;
import fi.samssi.creators.TextureRegionAndAtlas;
import fi.samssi.creators.TextureRegionAndAtlasCreator;
import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;

public class InvadersActivity extends BaseGameActivity {
    private final ZoomCamera zoomCamera = new ZoomCamera(0, 0, GameEngineCreator.DEFAULT_CAMERA_WIDTH, GameEngineCreator.DEFAULT_CAMERA_HEIGHT);
    private final Engine engine = new GameEngineCreator().createGameEngineWith(zoomCamera);
    //    private final Scene scene = new SceneCreator().createSceneWith(engine);
    private final float x = 100f;
    private final float y = 200f;
    private final TextureRegionAndAtlasCreator textureRegionAndAtlasCreator = new TextureRegionAndAtlasCreator(this);
    private TextureRegionAndAtlas spaceInvaderTextureRegionAndAtlas;
    private TextureRegionAndAtlas spaceShipTextureRegionAndAtlas;
    private final List<Invader> invaders = new ArrayList<Invader>();
    private SpaceShip spaceShip;

    @Override
    public Engine onLoadEngine() {
        return engine;
    }


    @Override
    public void onLoadResources() {
        final TextureManager textureManager = engine.getTextureManager();
        spaceInvaderTextureRegionAndAtlas = textureRegionAndAtlasCreator.createSpaceInvaderAtlas();
        textureManager.loadTexture(spaceInvaderTextureRegionAndAtlas.getSpaceInvaderAtlas());
        spaceShipTextureRegionAndAtlas = textureRegionAndAtlasCreator.createSpaceShipAtlas();
        textureManager.loadTexture(spaceShipTextureRegionAndAtlas.getSpaceInvaderAtlas());
    }

    @Override
    public Scene onLoadScene() {
        engine.registerUpdateHandler(new FPSLogger());
        invaders.add(new Invader(0, 0, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(0, 100, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(0, 200, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(100, 0, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(100, 100, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(x, y, spaceInvaderTextureRegionAndAtlas.getSpaceInvaderTextureRegion()));
        spaceShip = new SpaceShip(GameEngineCreator.DEFAULT_CAMERA_WIDTH / 2f, GameEngineCreator.DEFAULT_CAMERA_HEIGHT - 100f, spaceShipTextureRegionAndAtlas.getSpaceInvaderTextureRegion());
        return new SceneCreator().createSceneWith(invaders, spaceShip);
    }

    @Override
    public void onLoadComplete() {
    }

}