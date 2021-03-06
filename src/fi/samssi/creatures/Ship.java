package fi.samssi.creatures;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Ship extends Sprite {
    private final SecuritySystem securitySystem;

    public Ship(final float pX, final float pY, final TextureRegion pTextureRegion) {
        super(pX, pY, pTextureRegion);
        securitySystem = new SecuritySystem(1000, 250, 250);
    }

    public SecuritySystem getSecuritySystem() {
        return securitySystem;
    }
}
