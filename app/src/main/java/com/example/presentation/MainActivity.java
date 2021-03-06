package com.example.presentation;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DisplayManager displayManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVideo();
        Toast.makeText(getApplicationContext(), "YouTube for TV launched on connected screen. Please restart the app if the display disconnects.", Toast.LENGTH_LONG).show();
    }

    private void initVideo() {
        if (displayManager == null) {
            displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
            Display[] displays = displayManager.getDisplays();
            if (displays.length > 1) {
                ScreenPresentation screenPresentation = new ScreenPresentation(MainActivity.this, displays[1]);
                screenPresentation.show();
            }
        }

    }

}
