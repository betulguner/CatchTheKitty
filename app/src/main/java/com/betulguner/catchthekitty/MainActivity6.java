package com.betulguner.catchthekitty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity6 extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    int score;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        timeText = findViewById(R.id.timeText);
        //timeText.setText("376452");

        scoreText = findViewById(R.id.scoreText);
        //scoreText.setText("58762340");

        imageView =findViewById(R.id.imageView);
        imageView1 =findViewById(R.id.imageView1);
        imageView2 =findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5 =findViewById(R.id.imageView5);
        imageView6 =findViewById(R.id.imageView6);
        imageView7 =findViewById(R.id.imageView7);
        imageView8 =findViewById(R.id.imageView8);

        imageArray = new ImageView[] {imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};

        hideImages();
        score = 0;

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l)
            {
                timeText.setText("Time: "+ l/1000);
            }

            @Override
            public void onFinish()
            {
                timeText.setText("GAME OVER!");
                handler.removeCallbacks(runnable);


                for(ImageView image : imageArray)
                {
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity6.this);
                alert.setTitle("Restart?");
                alert.setMessage("Do you wanna play again?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        //restart
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity6.this, "End of the game!",Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();
            }
        }.start();
    }


    public void increaseScore(View view)
    {
        score++;
        scoreText.setText("Score: "+score);
        imageArray[i].setEnabled(false);
    }

    int i;

    public void hideImages()
    {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run()
            {
                for(ImageView image : imageArray)
                {
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                i =random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);

            }
        };

        handler.post(runnable);
    }

    public void backToMenu(View view)
    {
        Intent intent = new Intent (getApplicationContext(),MainActivity2.class);
        startActivity(intent);
    }
}