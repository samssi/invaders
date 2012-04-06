package fi.samssi.creators;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;

import fi.samssi.creatures.Invader;


public class SceneCreator {
    public Scene createSceneWith(final Invader... invaders) {
        final Scene scene = new Scene();
        scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
        for (Invader invader : invaders) {
            scene.registerTouchArea(invader);
            scene.attachChild(invader);
        }
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
}
