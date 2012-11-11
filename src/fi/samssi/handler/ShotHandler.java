package fi.samssi.handler;

import org.anddev.andengine.engine.handler.IUpdateHandler;

import fi.samssi.creatures.Shot;

public class ShotHandler implements IUpdateHandler {
    private final Shot shot;

    public ShotHandler(final Shot shot) {
        this.shot = shot;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        if (shot.getY() > 0) {
            shot.move();
            return;
        }
    }

    @Override
    public void reset() {}
}
