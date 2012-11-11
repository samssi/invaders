package fi.samssi.container;

import java.util.List;

import fi.samssi.creatures.Invader;
import fi.samssi.creatures.SpaceShip;

public class SceneContainer {
    private final SpaceShip spaceShip;
    private final List<Invader> invaders;

    public SceneContainer(final SpaceShip spaceShip, final List<Invader> invaders) {
        this.spaceShip = spaceShip;
        this.invaders = invaders;
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public List<Invader> getInvaders() {
        return invaders;
    }
}
