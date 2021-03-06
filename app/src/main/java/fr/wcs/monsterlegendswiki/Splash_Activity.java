package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.vous_netes_pas_pret);
        mediaPlayer.start();

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(6000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();
    }
}
