package com.energyxxer.pplayer.presentationutil;

import com.energyxxer.pplayer.presentationutil.enums.Easing;

import static com.energyxxer.pplayer.presentationutil.enums.Easing.LINEAR;

/**
 * Created by User on 2/1/2017.
 */
public class ObjectTransition {

    public int keyframe = 0;
    public Easing easing = LINEAR;
    public ObjectState state = null;

    public ObjectTransition() {
    }

    public ObjectTransition(int keyframe, Easing easing) {
        this.keyframe = keyframe;
        this.easing = easing;
    }

    public ObjectTransition(int keyframe, Easing easing, ObjectState state) {
        this.keyframe = keyframe;
        this.easing = easing;
        this.state = state;
    }
}
