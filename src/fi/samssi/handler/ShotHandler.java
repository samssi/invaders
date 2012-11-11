package fi.samssi.handler;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;

import fi.samssi.creatures.Shot;

public class ShotHandler implements IUpdateHandler {
    private final Shot shot;
    private final List<Shot> shotsOnRoute;

    public ShotHandler(final Shot shot, final List<Shot> shotsOnRoute) {
        this.shot = shot;
        this.shotsOnRoute = shotsOnRoute;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        if (shot.getY() > Shot.HIDDEN) {
            shot.move();
            return;
        }
        shotsOnRoute.remove(shot);
    }

    @Override
    public void reset() {}
}
