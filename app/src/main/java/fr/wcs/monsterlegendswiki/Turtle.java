package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
    ImageView imagebuttonTurtle1;
    ImageView imagebuttonTurtle2;
    ImageView imagebuttonTurtle3;


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
        imagebuttonTurtle1 = findViewById(R.id.imageView_buttonTurtle1);
        imagebuttonTurtle2 = findViewById(R.id.imageView_buttonTurtle2);
        imagebuttonTurtle3 = findViewById(R.id.imageView_buttonTurtle3);

        seekBarLevel.setMax(20);

        final MyMonster monsterTurtle = new MyMonster(0, 220, 70, 175, 100);

        fillTextView(monsterTurtle);

        imagebuttonTurtle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(1);
            }
        });

        imagebuttonTurtle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(4);
            }
        });

        imagebuttonTurtle3.setOnClickListener(new View.OnClickListener() {
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
                monsterTurtle.evolution(level);
                fillTextView(monsterTurtle);
                if (level == 0 ){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_turtle_0);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.turtle_egg);
                }
                else if (level < 4){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_turtle_1);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.turtle_1);
                }
                else if (level < 7){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_turtle_2);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.turtle_2);
                }
                else {
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_turtle_3);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
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
        textViewTitle.setText("level : " + firelion.getmLevel());
        textViewLife.setText("" + firelion.getmLife());
        textViewSpeed.setText("" + firelion.getmSpeed());
        textViewStamina.setText("" + firelion.getmStamina());
        textViewPower.setText(""   + firelion.getmPower());
    }
}
