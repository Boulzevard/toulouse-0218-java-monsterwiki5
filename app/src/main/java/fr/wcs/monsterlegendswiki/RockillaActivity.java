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

public class RockillaActivity extends AppCompatActivity {

    // TODO : faire les même corrections que FireLionActivity
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

        final MonsterModel monsterRockilla = new MonsterModel(0, 220, 70, 175, 100);

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
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_rockilla_0);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.rockilla_egg);
                }
                else if (level < 4){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_rockilla_1);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.rockilla_1);
                }
                else if (level < 7){
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_rockilla_2);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                    imageViewMonster.setImageResource(R.drawable.rockilla_2);
                }
                else {
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_rockilla_3);
                    myThumb.setBounds( new Rect( 0, 0 ,myThumb.getIntrinsicWidth(),myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
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
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    public void fillTextView(MonsterModel firelion){
        textViewTitle.setText("level : " + firelion.getLevel());
        textViewLife.setText("" + firelion.getLife());
        textViewSpeed.setText("" + firelion.getSpeed());
        textViewStamina.setText("" + firelion.getStamina());
        textViewPower.setText(""   + firelion.getPower());
    }
}
