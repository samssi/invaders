package fi.samssi.handler;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.creatures.Shot;

public class ShotHandler implements IUpdateHandler {
    private final Scene scene;
    private final Shot shot;

    public ShotHandler(final Shot shot, final Scene scene) {
        this.shot = shot;
        this.scene = scene;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        if (shot.getY() > 1000f) {
            shot.setPosition(shot.getX(), 0);
            scene.detachChild(shot);
            return;
        }
        shot.move();
    }

    @Override
    public void reset() {}
}
