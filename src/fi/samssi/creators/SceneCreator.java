package fi.samssi.creators;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;

import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;


public class SceneCreator {
    public Scene createSceneWith(final List<Invader> invaders, final SpaceShip spaceShip) {
        final Scene scene = new Scene();
        scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
        attachInvaders(scene, invaders);
        attachSpaceShip(scene, spaceShip);
        scene.registerUpdateHandler(new IUpdateHandler() {
            @Override
            public void onUpdate(final float pSecondsElapsed) {
                for (Invader invader : invaders) {
                    invader.move();
                }
            }

            @Override
            public void reset() {
            }
        });
        return scene;
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
