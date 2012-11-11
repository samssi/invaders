package fi.samssi.handler;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.creatures.Invader;
import fi.samssi.creatures.Shot;

public class InvadersHandler implements IUpdateHandler {
    private final List<Invader> invaders;
    private final List<Shot> shotsOnRoute;
    private final Scene scene;

    public InvadersHandler(final List<Invader> invaders, final List<Shot> shotsOnRoute, final Scene scene) {
        this.invaders = invaders;
        this.shotsOnRoute = shotsOnRoute;
        this.scene = scene;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        for (Invader invader : invaders) {
            for (Shot shot : shotsOnRoute) {
                if (invader.collidesWith(shot)) {
                    scene.detachChild(invader);
                }
            }
            invader.move();
        }
    }

    @Override
    public void reset() {}
}
