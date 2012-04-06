package fi.samssi.creatures;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import fi.samssi.creators.GameEngineCreator;

public class Invader extends Sprite {

    private Direction direction = Direction.RIGHT;

    public Invader(final float centerX, final float centerY, final TextureRegion myTextureRegion) {
        super(centerX, centerY, myTextureRegion);
    }

    @Override
    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
        this.setPosition(this.getX() + 5f, this.getY() - 1f);
        this.setRotation(this.getRotation() + 5f);
        return true;
    }

    public void move() {
        directionChange();
        if (direction.equals(Direction.LEFT)) {
            this.setPosition(this.getX() - 10f, this.getY());
        }
        if (direction.equals(Direction.RIGHT)) {
            this.setPosition(this.getX() + 10f, this.getY());
        }

    }

    private void directionChange() {
        if (this.getX() > GameEngineCreator.DEFAULT_CAMERA_WIDTH) {
            direction = Direction.LEFT;
            this.setPosition(this.getX(), this.getY() + 100f);
        }
        if (this.getX() < 0) {
            direction = Direction.RIGHT;
            this.setPosition(this.getX(), this.getY() + 100f);
        }
    }
}
