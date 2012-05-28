package com.hoffenkloffen.babymoz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class HelpActivity extends Activity {

    private WebView html;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        html = (WebView)findViewById(R.id.help);
        html.loadUrl("file:///android_asset/help.html");
    }
}
