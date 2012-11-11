package fi.samssi.handler;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.creatures.Invader;
import fi.samssi.creatures.Shot;

public class InvadersHandler implements IUpdateHandler {
    private final List<Invader> invaders;
    private final Shot shot;
    private final Scene scene;

    public InvadersHandler(final List<Invader> invaders, final Shot shot, final Scene scene) {
        this.invaders = invaders;
        this.shot = shot;
        this.scene = scene;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        for (Invader invader : invaders) {
            if (invader.collidesWith(shot)) {
                scene.detachChild(invader);
            }
            invader.move();
        }
    }

    @Override
    public void reset() {}
}
