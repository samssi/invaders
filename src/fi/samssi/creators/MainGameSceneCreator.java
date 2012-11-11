package fi.samssi.creators;

import static fi.samssi.creators.Atlas.INVADER;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.input.touch.TouchEvent;

import android.view.GestureDetector;
import fi.samssi.SpaceShipGestureDetector;
import fi.samssi.container.HashMapAtlasContainer;
import fi.samssi.container.SceneContainer;
import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;


public class MainGameSceneCreator implements IOnSceneTouchListener {
    private final SceneContainer sceneContainer;
    private final GestureDetector gestureDetector;
    final Scene scene = new Scene();
    private final HashMapAtlasContainer<TextureRegionAndAtlas> textureRegionAndAtlasContainer;


    public MainGameSceneCreator(final HashMapAtlasContainer<TextureRegionAndAtlas> textureRegionAndAtlasContainer) {
        this.textureRegionAndAtlasContainer = textureRegionAndAtlasContainer;
        this.sceneContainer = new SceneContainer(createSpaceShip(), populateInvaders());
        this.gestureDetector = new GestureDetector(new SpaceShipGestureDetector(sceneContainer.getSpaceShip()));
    }

    private SpaceShip createSpaceShip() {
        return new SpaceShip(GameEngineCreator.DEFAULT_CAMERA_WIDTH / 2f, GameEngineCreator.DEFAULT_CAMERA_HEIGHT - 100f, textureRegionAndAtlasContainer, scene);
    }

    public Scene createScene() {
        scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
        attachInvaders(sceneContainer.getInvaders());
        scene.attachChild(sceneContainer.getSpaceShip());
        scene.setOnSceneTouchListener(this);
        return scene;
    }

    private List<Invader> populateInvaders() {
        List<Invader> invaders = new ArrayList<Invader>();
        invaders.add(new Invader(0, 0, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(0, 100, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(0, 200, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(100, 0, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(100, 100, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        invaders.add(new Invader(100, 200, textureRegionAndAtlasContainer.get(INVADER).getSpaceInvaderTextureRegion()));
        return invaders;
    }


    @Override
    public boolean onSceneTouchEvent(final Scene scene, final TouchEvent pSceneTouchEvent) {
        sceneContainer.getSpaceShip().setPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
        gestureDetector.onTouchEvent(pSceneTouchEvent.getMotionEvent());
        return true;
    }

    private void attachInvaders(final List<Invader> invaders) {
        for (Invader invader : invaders) {
            scene.registerTouchArea(invader);
            scene.attachChild(invader);
        }
        //        scene.registerUpdateHandler(new InvadersHandler(invaders, spaceShip.getShot(), scene));
    }
}
