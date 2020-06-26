package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView brainImageView;
    Button button;

    public void nextScreen (View view){

        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

        startActivity(intent);
        //finish();

    }

   public void animationButton () {
        //sumTextView = findViewById (R.id.sumTextView); find view by id in on create method
        ObjectAnimator.ofFloat (button, "translationX", 0.0f, 0.0f) .start ();
        ObjectAnimator.ofFloat (button, "translationY", 600.0f, 0.0f) .start ();
    }

    public void animationBrain () {
        //sumTextView = findViewById (R.id.sumTextView); find view by id in on create method
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(brainImageView,
                PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(500);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brainImageView = findViewById(R.id.brainImageView);
        button = findViewById(R.id.button);
       animationBrain();
       animationButton();

    }
}