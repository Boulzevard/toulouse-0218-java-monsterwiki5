package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Turtle extends AppCompatActivity {

    private ImageView retourTurtle;
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
        setContentView(R.layout.activity_turtle);

        textViewTitle = findViewById(R.id.textView_Turtle);
        textViewPower = findViewById(R.id.textView_powerTurtle);
        textViewLife = findViewById(R.id.textView_lifeTurtle);
        textViewSpeed = findViewById(R.id.textView_speedTurtle);
        textViewStamina = findViewById(R.id.textView_staminaTurtle);
        seekBarLevel = findViewById(R.id.seekBar_levelTurtle);
        textViewValue = findViewById(R.id.textView_valueTurtle);
        imageViewMonster = findViewById(R.id.imageView_monsterTurtle);

        seekBarLevel.setMax(20);

        final MyMonster monsterTurtle = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterTurtle);

        seekBarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int level = i;

                textViewValue.setText(String.valueOf(level));
                monsterTurtle.evolution(level);
                fillTextView(monsterTurtle);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.turtle_egg);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.turtle_1);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.turtle_2);
                }
                else {
                    imageViewMonster.setImageResource(R.drawable.turtle_3);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.retourTurtle = findViewById(R.id.retour_turtle);

        retourTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour3);
                finish();
            }
        });
    }

    public void fillTextView(MyMonster firelion){
        textViewTitle.setText("Turtle level : " + firelion.getmLevel());
        textViewLife.setText("Life : " + firelion.getmLife());
        textViewSpeed.setText("Speed : " + firelion.getmSpeed());
        textViewStamina.setText("Stamina : " + firelion.getmStamina());
        textViewPower.setText("Power : "   + firelion.getmPower());
    }
}
