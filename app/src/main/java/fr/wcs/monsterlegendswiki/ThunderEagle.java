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

public class ThunderEagle extends AppCompatActivity {

    private ImageView retourThunderEagle;
    TextView textViewTitle;
    TextView textViewPower;
    TextView textViewLife;
    TextView textViewSpeed;
    TextView textViewStamina;
    TextView textViewValue;
    SeekBar seekBarLevel;
    ImageView imageViewMonster;
    ImageView imagebuttonThunderEagle1;
    ImageView imagebuttonThunderEagle2;
    ImageView imagebuttonThunderEagle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thunder_eagle);

        textViewTitle = findViewById(R.id.textView_ThunderEagle);
        textViewPower = findViewById(R.id.textView_powerThunderEagle);
        textViewLife = findViewById(R.id.textView_lifeThunderEagle);
        textViewSpeed = findViewById(R.id.textView_speedThunderEagle);
        textViewStamina = findViewById(R.id.textView_staminaThunderEagle);
        seekBarLevel = findViewById(R.id.seekBar_levelThunderEagle);
        textViewValue = findViewById(R.id.textView_valueThunderEagle);
        imageViewMonster = findViewById(R.id.imageView_monsterThunderEagle);
        imagebuttonThunderEagle1 = findViewById(R.id.imageView_buttonThunderEagle1);
        imagebuttonThunderEagle2 = findViewById(R.id.imageView_buttonThunderEagle2);
        imagebuttonThunderEagle3 = findViewById(R.id.imageView_buttonThunderEagle3);

        seekBarLevel.setMax(20);

        final MyMonster monsterThunderEagle = new MyMonster(0, 220, 70, 175, 100);

        fillTextView(monsterThunderEagle);

        imagebuttonThunderEagle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(1);
            }
        });

        imagebuttonThunderEagle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarLevel.setProgress(4);
            }
        });

        imagebuttonThunderEagle3.setOnClickListener(new View.OnClickListener() {
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
                monsterThunderEagle.evolution(level);
                fillTextView(monsterThunderEagle);
                if (level == 0 ){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_thundereagle_0);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.thunder_eagle_huevo);
                }
                else if (level < 4){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_thundereagle_1);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.thundereagle_1);
                }
                else if (level < 7){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_thundereagle_2);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.thundereagle_2);
                }
                else {
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_thundereagle_3);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.thundereagle_3);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.retourThunderEagle = findViewById(R.id.retour_thunderEagle);
        retourThunderEagle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour5 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour5);
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
