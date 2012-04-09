package fi.samssi.handler;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;

public class InvadersHandler implements IUpdateHandler {
    private final List<Invader> invaders;
    private final SpaceShip spaceShip;
    private final Scene scene;

    public InvadersHandler(final List<Invader> invaders, final SpaceShip spaceShip, final Scene scene) {
        this.invaders = invaders;
        this.spaceShip = spaceShip;
        this.scene = scene;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        for (Invader invader : invaders) {
            if (invader.collidesWith(spaceShip)) {
                spaceShip.getSecuritySystem().registerCollision(100);
                scene.detachChild(invader);
            }
            invader.move();
        }
    }

    @Override
    public void reset() {}
}
