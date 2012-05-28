package com.hoffenkloffen.babymoz;

import com.hoffenkloffen.babymoz.core.Animation;
import com.hoffenkloffen.babymoz.core.Resource;

public interface ResourceManager {

    int getResId(Resource resource);

    android.view.animation.Animation getAnimation(Animation animation);
}
