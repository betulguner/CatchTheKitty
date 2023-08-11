package com.betulguner.catchthekitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void play(View view)
    {
        Intent intent = new Intent(MainActivity2.this,MainActivity4.class);

        startActivity(intent);
    }

    public void howToPlay(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        startActivity(intent);
    }

    public void exit(View view)
    {
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exitIntent);

        //System.exit(0);
    }




}