package fi.samssi.creatures;

import static fi.samssi.creators.GameEngineCreator.DEFAULT_CAMERA_WIDTH;
import static fi.samssi.creatures.Direction.LEFT;
import static fi.samssi.creatures.Direction.RIGHT;

import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Invader extends Ship {

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
        if (direction.equals(LEFT)) {
            this.setPosition(this.getX() - 10f, this.getY());
        }
        if (direction.equals(RIGHT)) {
            this.setPosition(this.getX() + 10f, this.getY());
        }

    }

    private void directionChange() {
        if (this.getX() > DEFAULT_CAMERA_WIDTH) {
            direction = LEFT;
            this.setPosition(this.getX(), this.getY() + 100f);
        }
        if (this.getX() < 0) {
            direction = RIGHT;
            this.setPosition(this.getX(), this.getY() + 100f);
        }
    }
}
