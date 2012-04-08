package fi.samssi.creators;

import java.util.List;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.input.touch.TouchEvent;

import android.view.GestureDetector;
import fi.samssi.OnGameGestureDetector;
import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;
import fi.samssi.handler.InvadersHandler;


public class MainGameSceneCreator implements IOnSceneTouchListener {
    private final SpaceShip spaceShip;
    private final List<Invader> invaders;
    private final GestureDetector gestureDetector;

    public MainGameSceneCreator(final SpaceShip spaceShip, final List<Invader> invaders) {
        this.spaceShip = spaceShip;
        this.invaders = invaders;
        this.gestureDetector = new GestureDetector(new OnGameGestureDetector());
    }

    public Scene createScene() {
        final Scene scene = new Scene();
        scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
        attachInvaders(scene, invaders);
        attachSpaceShip(scene, spaceShip);
        scene.registerUpdateHandler(new InvadersHandler(invaders));
        scene.setOnSceneTouchListener(this);
        return scene;
    }


    @Override
    public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pSceneTouchEvent) {
        spaceShip.setPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
        gestureDetector.onTouchEvent(pSceneTouchEvent.getMotionEvent());
        return true;
    }

    private void attachSpaceShip(final Scene scene, final SpaceShip spaceShip) {
        scene.attachChild(spaceShip);
    }

    private void attachInvaders(final Scene scene, final List<Invader> invaders) {
        for (Invader invader : invaders) {
            scene.registerTouchArea(invader);
            scene.attachChild(invader);
        }
    }
}
