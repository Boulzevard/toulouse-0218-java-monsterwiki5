package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class FireLion extends AppCompatActivity {

    private ImageView retourFire;
    TextView textViewTitle;
    TextView textViewPower;
    TextView textViewLife;
    TextView textViewSpeed;
    TextView textViewStamina;
    TextView textViewValue;
    SeekBar seekBarLevel;
    ImageView imageViewMonster;
    ImageView imagebutton1;
    ImageView imagebutton2;
    ImageView imagebutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_lion);

        textViewTitle = findViewById(R.id.textView_Firelion);
        textViewPower = findViewById(R.id.textView_StatPower);
        textViewLife = findViewById(R.id.textView_StatLife);
        textViewSpeed = findViewById(R.id.textView_StatSpeed);
        textViewStamina = findViewById(R.id.textView_StatStamina);
        seekBarLevel = findViewById(R.id.seekBar_level);
        textViewValue = findViewById(R.id.textView_value);
        imageViewMonster = findViewById(R.id.imageView_monster);
        imagebutton1 = findViewById(R.id.imageView_button1);
        imagebutton2 = findViewById(R.id.imageView_button2);
        imagebutton3 = findViewById(R.id.imageView_button3);

        seekBarLevel.setMax(20);

        final MyMonster monsterFirelion = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterFirelion);

        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(1);
            }
        });

        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(4);
            }
        });

        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(7);
            }
        });


        seekBarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                final int level = i;


                textViewValue.setText(String.valueOf(level));
                monsterFirelion.evolution(level);
                fillTextView(monsterFirelion);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.eggfirelion);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.firelion);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.ui_fire_lion_2);
                }
                else {
                    imageViewMonster.setImageResource(R.drawable.ui_fire_lion_3);
                }



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






        this.retourFire = findViewById(R.id.retour_fire);

        retourFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour1);
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

