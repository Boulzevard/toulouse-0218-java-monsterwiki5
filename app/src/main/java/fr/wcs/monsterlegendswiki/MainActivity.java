package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView playFire;
    private ImageView playTurtle;
    private ImageView playRockilla;
    private ImageView playThunderEagle;
    private ImageView playPanda;
    private ImageView playshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.playFire = findViewById(R.id.fire_lion);

        playFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mooveFire = new Intent(getApplicationContext(),FireLion.class);
                startActivity(mooveFire);
                finish();
            }
        });

        this.playTurtle = findViewById(R.id.turtle);

        playTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mooveTurtle = new Intent(getApplicationContext(),Turtle.class);
                startActivity(mooveTurtle);
                finish();
            }
        });

        this.playRockilla = findViewById(R.id.rockilla);

        playRockilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mooveRockilla = new Intent(getApplicationContext(),Rockilla.class);
                startActivity(mooveRockilla);
                finish();
            }
        });

        this.playThunderEagle = findViewById(R.id.thunder_eagle);

        playThunderEagle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mooveThunderEagle = new Intent(getApplicationContext(),ThunderEagle.class);
                startActivity(mooveThunderEagle);
                finish();
            }
        });

        this.playPanda = findViewById(R.id.panda);

        playPanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moovePanda = new Intent(getApplicationContext(),Panda.class);
                startActivity(moovePanda);
                finish();
            }
        });

        this.playshop = findViewById(R.id.imageView_shop);

        playshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mooveShop = new Intent(getApplicationContext(), PayeActivity.class);
                startActivity(mooveShop);
                finish();
            }
        });

    }

}
