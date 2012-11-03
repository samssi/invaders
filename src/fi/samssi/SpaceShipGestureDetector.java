package fi.samssi;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import fi.samssi.creatures.SpaceShip;

public class SpaceShipGestureDetector extends SimpleOnGestureListener {
    private final SpaceShip spaceShip;

    public SpaceShipGestureDetector(final SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }

    @Override
    public boolean onSingleTapConfirmed(final MotionEvent e) {
        spaceShip.fire();
        return true;
    }
}
