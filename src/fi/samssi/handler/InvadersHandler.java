package fi.samssi.handler;

import java.util.List;

import org.anddev.andengine.engine.handler.IUpdateHandler;

import fi.samssi.creatures.Invader;

public class InvadersHandler implements IUpdateHandler {
    private final List<Invader> invaders;

    public InvadersHandler(final List<Invader> invaders) {
        this.invaders = invaders;
    }

    @Override
    public void onUpdate(final float pSecondsElapsed) {
        for (Invader invader : invaders) {
            invader.move();
        }
    }

    @Override
    public void reset() {}
}
