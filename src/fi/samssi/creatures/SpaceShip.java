package fi.samssi.creatures;

import static fi.samssi.creators.Atlas.SHOT;
import static fi.samssi.creators.Atlas.SPACESHIP;

import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.creators.TextureRegionAndAtlasContainer;
import fi.samssi.handler.ShotHandler;

public class SpaceShip extends Ship {
    private final TextureRegionAndAtlasContainer textureContainer;
    private final Scene scene;


    public SpaceShip(final float pX, final float pY, final TextureRegionAndAtlasContainer textureContainer, final Scene scene) {
        super(pX, pY, textureContainer.get(SPACESHIP).getSpaceInvaderTextureRegion());
        this.textureContainer = textureContainer;
        this.scene = scene;
    }

    public void fire() {
        Shot shot = new Shot(0, Shot.HIDDEN, textureContainer.get(SHOT).getSpaceInvaderTextureRegion());
        shot.setPosition(this.getX(), this.getY());
        scene.attachChild(shot);
        scene.registerUpdateHandler(new ShotHandler(shot));
    }

}
