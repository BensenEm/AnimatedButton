package de.materna.myapplication;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl;
    Button button;
    StateListDrawable btnAnimation;
    Drawable current;
    Button testButton;
    AnimatedVectorDrawable vectorAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = (ConstraintLayout) findViewById(R.id.cl);
        button = (Button) findViewById(R.id.button);

        //Fontadjustment I - sets default font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public void buttonCallback(View view) {
        button = (Button) findViewById(R.id.button);
        //StateListDrawable as Drawable is taken via Selector in "button_main.xml"
        btnAnimation = (StateListDrawable) button.getBackground();
        current = btnAnimation.getCurrent();
        if (current instanceof AnimatedVectorDrawable) {
            vectorAnimation= (AnimatedVectorDrawable) current;
            vectorAnimation.stop();
            vectorAnimation.start();
        }
    }

    public void testButtonCallback(View view) {
        testButton = (Button) findViewById(R.id.testButton);
        vectorAnimation = (AnimatedVectorDrawable) testButton.getBackground();
        vectorAnimation.start();
    }

    //Fontadjustment II - required for something ... ???
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
