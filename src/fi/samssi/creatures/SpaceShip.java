package fi.samssi.creatures;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class SpaceShip extends Ship {
    private final Shot shot;

    public SpaceShip(final float pX, final float pY, final TextureRegion pTextureRegion, final Shot shot) {
        super(pX, pY, pTextureRegion);
        this.shot = shot;
    }

    public void fire() {
        shot.setPosition(this.getX(), this.getY());
    }

    public Shot getShot() {
        return shot;
    }
}
