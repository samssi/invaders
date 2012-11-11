package fi.samssi.creatures;

import static fi.samssi.creators.Atlas.SHOT;
import static fi.samssi.creators.Atlas.SPACESHIP;

import org.anddev.andengine.entity.scene.Scene;

import fi.samssi.container.HashMapAtlasContainer;
import fi.samssi.creators.TextureRegionAndAtlas;
import fi.samssi.handler.ShotHandler;

public class SpaceShip extends Ship {
    private final HashMapAtlasContainer<TextureRegionAndAtlas> textureRegionAndAtlasContainer;
    private final Scene scene;


    public SpaceShip(final float pX, final float pY, final HashMapAtlasContainer<TextureRegionAndAtlas> textureRegionAndAtlasContainer, final Scene scene) {
        super(pX, pY, textureRegionAndAtlasContainer.get(SPACESHIP).getSpaceInvaderTextureRegion());
        this.textureRegionAndAtlasContainer = textureRegionAndAtlasContainer;
        this.scene = scene;
    }

    public void fire() {
        Shot shot = new Shot(0, Shot.HIDDEN, textureRegionAndAtlasContainer.get(SHOT).getSpaceInvaderTextureRegion());
        shot.setPosition(this.getX(), this.getY());
        scene.attachChild(shot);
        scene.registerUpdateHandler(new ShotHandler(shot));
    }

}
