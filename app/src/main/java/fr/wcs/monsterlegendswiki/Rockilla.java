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

        seekBarLevel.setMax(20);

        final MyMonster monsterRockilla = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterRockilla);

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
        textViewTitle.setText("Rockilla level : " + firelion.getmLevel());
        textViewLife.setText("Life : " + firelion.getmLife());
        textViewSpeed.setText("Speed : " + firelion.getmSpeed());
        textViewStamina.setText("Stamina : " + firelion.getmStamina());
        textViewPower.setText("Power : "   + firelion.getmPower());
    }
}
