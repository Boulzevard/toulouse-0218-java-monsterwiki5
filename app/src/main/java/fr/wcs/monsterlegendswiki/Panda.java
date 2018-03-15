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

public class Panda extends AppCompatActivity {

    private ImageView retourPanda;
    TextView textViewTitle;
    TextView textViewPower;
    TextView textViewLife;
    TextView textViewSpeed;
    TextView textViewStamina;
    TextView textViewValue;
    SeekBar seekBarLevel;
    ImageView imageViewMonster;
    ImageView imagebuttonPanda1;
    ImageView imagebuttonPanda2;
    ImageView imagebuttonPanda3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda);

        textViewTitle = findViewById(R.id.textView_Panda);
        textViewPower = findViewById(R.id.textView_powerPanda);
        textViewLife = findViewById(R.id.textView_lifePanda);
        textViewSpeed = findViewById(R.id.textView_speedPanda);
        textViewStamina = findViewById(R.id.textView_staminaPanda);
        seekBarLevel = findViewById(R.id.seekBar_levelPanda);
        textViewValue = findViewById(R.id.textView_valuePanda);
        imageViewMonster = findViewById(R.id.imageView_monsterPanda);
        imagebuttonPanda1 =findViewById(R.id.imageView_buttonPanda1);
        imagebuttonPanda2 =findViewById(R.id.imageView_buttonPanda2);
        imagebuttonPanda3 =findViewById(R.id.imageView_buttonPanda3);

        seekBarLevel.setMax(20);

        final MyMonster monsterPanda = new MyMonster(0, 220, 70, 175, 100);

        fillTextView(monsterPanda);

        imagebuttonPanda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(1);
            }
        });

        imagebuttonPanda2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(4);
            }
        });

        imagebuttonPanda3.setOnClickListener(new View.OnClickListener() {
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
                monsterPanda.evolution(level);
                fillTextView(monsterPanda);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.treezard_huevo);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_panda_0);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.panda_1);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_panda_1);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.panda_2);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_panda_2);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                }
                else {
                    imageViewMonster.setImageResource(R.drawable.panda_3);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_panda_3);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.retourPanda = findViewById(R.id.retour_panda);

        retourPanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour2);
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
