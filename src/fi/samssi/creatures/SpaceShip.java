package fi.samssi.creatures;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class SpaceShip extends Ship {
    public SpaceShip(final float pX, final float pY, final TextureRegion pTextureRegion) {
        super(pX, pY, pTextureRegion);
    }

    public void fire() {
        System.err.println("Fire!!!");
    }
}
