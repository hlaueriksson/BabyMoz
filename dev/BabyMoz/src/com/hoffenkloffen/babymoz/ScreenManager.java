package com.hoffenkloffen.babymoz;

import com.hoffenkloffen.babymoz.core.Animation;
import com.hoffenkloffen.babymoz.core.Content;
import com.hoffenkloffen.babymoz.core.Style;

public interface ScreenManager
{
    void display(Content content);
    void apply(Style style);
    void start(Animation animation);
}
