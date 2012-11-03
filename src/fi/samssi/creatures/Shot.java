package fi.samssi.creatures;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Shot extends Sprite {
    public Shot(final float pX, final float pY, final TextureRegion pTextureRegion) {
        super(pX, pY, pTextureRegion);
    }

    public void move() {
        this.setPosition(this.getX(), this.getY() + 5);
    }
}
