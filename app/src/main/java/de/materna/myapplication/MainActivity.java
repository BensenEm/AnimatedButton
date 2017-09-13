package de.materna.myapplication;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl= (ConstraintLayout) findViewById(R.id.cl);
        button = (ImageButton) findViewById(R.id.button);
    }

    public void changeText(View view){
        ((Animatable) button.getDrawable()).stop();
        ((Animatable) button.getDrawable()).start();
    }

}
