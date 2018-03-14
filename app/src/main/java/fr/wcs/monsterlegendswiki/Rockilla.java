package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Rockilla extends AppCompatActivity {

    private ImageView retourRockilla;
    TextView textViewTitle;
    TextView textViewPower;
    TextView textViewLife;
    TextView textViewSpeed;
    TextView textViewStamina;
    TextView textViewValue;
    SeekBar seekBarLevel;
    ImageView imageViewMonster;
    ImageView imagebuttonRockilla1;
    ImageView imagebuttonRockilla2;
    ImageView imagebuttonRockilla3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockilla);

        textViewTitle = findViewById(R.id.textView_Rockilla);
        textViewPower = findViewById(R.id.textView_powerRockilla);
        textViewLife = findViewById(R.id.textView_lifeRockilla);
        textViewSpeed = findViewById(R.id.textView_speedRockilla);
        textViewStamina = findViewById(R.id.textView_staminaRockilla);
        seekBarLevel = findViewById(R.id.seekBar_levelRockilla);
        textViewValue = findViewById(R.id.textView_valueRockilla);
        imageViewMonster = findViewById(R.id.imageView_monsterRockilla);
        imagebuttonRockilla1 = findViewById(R.id.imageView_buttonRockilla1);
        imagebuttonRockilla2 = findViewById(R.id.imageView_buttonRockilla2);
        imagebuttonRockilla3 = findViewById(R.id.imageView_buttonRockilla3);

        seekBarLevel.setMax(20);

        final MyMonster monsterRockilla = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterRockilla);

        imagebuttonRockilla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(1);
            }
        });

        imagebuttonRockilla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(4);
            }
        });

        imagebuttonRockilla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(7);
            }
        });

        seekBarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int level = i;

                textViewValue.setText(String.valueOf(level));
                monsterRockilla.evolution(level);
                fillTextView(monsterRockilla);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.rockilla_egg);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.rockilla_1);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.rockilla_2);
                }
                else {
                    imageViewMonster.setImageResource(R.drawable.rockilla_3);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.retourRockilla = findViewById(R.id.retour_rockilla);

        retourRockilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour4 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour4);
                finish();
            }
        });
    }

    public void fillTextView(MyMonster firelion){
        textViewTitle.setText("level : " + firelion.getmLevel());
        textViewLife.setText("" + firelion.getmLife());
        textViewSpeed.setText("" + firelion.getmSpeed());
        textViewStamina.setText("" + firelion.getmStamina());
        textViewPower.setText(""   + firelion.getmPower());
    }
}
