package com.energyxxer.npplayer.transitions;

import com.energyxxer.npplayer.state.VisualState;

/**
 * Created by User on 3/26/2017.
 */
public class VisualTransition {
    private final int keyframe;
    private final Easing easing;
    private final VisualState state;

    public VisualTransition(int keyframe, VisualState state) {
        this(keyframe, Easing.LINEAR, state);
    }

    public VisualTransition(int keyframe, Easing easing, VisualState state) {
        this.keyframe = keyframe;
        this.easing = easing;
        this.state = state;
    }

    public int getKeyframe() {
        return keyframe;
    }

    public Easing getEasing() {
        return easing;
    }

    public VisualState getState() {
        return state;
    }
}
