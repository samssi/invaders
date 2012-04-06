package fi.samssi.creators;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;

public class GameEngineCreator {
    public static final int DEFAULT_CAMERA_WIDTH = 2000;
    public static final int DEFAULT_CAMERA_HEIGHT = 1600;

    public Engine createGameEngineWith(final ZoomCamera zoomCamera) {
        return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, createRatioResolutionPolicy(), zoomCamera));
    }

    private RatioResolutionPolicy createRatioResolutionPolicy() {
        return new RatioResolutionPolicy(DEFAULT_CAMERA_WIDTH, DEFAULT_CAMERA_HEIGHT);
    }
}
