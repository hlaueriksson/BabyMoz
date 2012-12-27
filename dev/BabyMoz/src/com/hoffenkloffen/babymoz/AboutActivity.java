package com.hoffenkloffen.babymoz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends Activity {

    private WebView html;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        String url = String.format("file:///android_asset/%s/about.html", getString(R.string.locale));

        html = (WebView)findViewById(R.id.about);
        html.loadUrl(url);
    }
}
