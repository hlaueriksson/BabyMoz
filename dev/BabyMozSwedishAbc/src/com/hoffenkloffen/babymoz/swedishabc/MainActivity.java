package com.hoffenkloffen.babymoz.swedishabc;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.hoffenkloffen.babymoz.BaseActivity;
import com.hoffenkloffen.babymoz.MainScreenManager;

public class MainActivity extends BaseActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setScreenManager(
                new MainScreenManager(
                        this,
                        findViewById(R.id.layout),
                        (TextView) findViewById(R.id.symbol),
                        (ImageView) findViewById(R.id.image)));

        init();
    }

    @Override
    protected String getPackage() {
        return "com.hoffenkloffen.babymoz.swedishabc";
    }
}
