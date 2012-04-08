package fi.samssi;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class OnGameGestureDetector extends SimpleOnGestureListener {
    @Override
    public boolean onSingleTapConfirmed(final MotionEvent e) {
        System.err.println("single tap");
        return true;
    }
}
