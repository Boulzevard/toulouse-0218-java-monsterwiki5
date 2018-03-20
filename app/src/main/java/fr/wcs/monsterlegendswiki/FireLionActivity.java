package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class FireLionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_lion);

        final SeekBar seekBarLevel = findViewById(R.id.seekbar_level);
        final ImageView imageViewMonster = findViewById(R.id.iv_monster);
        ImageView imagebutton1 = findViewById(R.id.iv_level1);
        ImageView imagebutton2 = findViewById(R.id.iv_level2);
        ImageView imagebutton3 = findViewById(R.id.iv_level3);

        seekBarLevel.setMax(20);

        final MonsterModel monsterFirelion = new MonsterModel(0, 220, 70, 175, 100);

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
            public void onProgressChanged(SeekBar seekBar, int level, boolean b) {
                TextView textViewValue = findViewById(R.id.tv_value);
                textViewValue.setText(String.valueOf(level));
                monsterFirelion.evolution(level);
                fillTextView(monsterFirelion);
                if (level == 0) {
                    imageViewMonster.setImageResource(R.drawable.eggfirelion);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_firelion0);
                    myThumb.setBounds(new Rect(0, 0, myThumb.getIntrinsicWidth(), myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);
                } else if (level < 4) {
                    imageViewMonster.setImageResource(R.drawable.firelion);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_firelion1);
                    myThumb.setBounds(new Rect(0, 0, myThumb.getIntrinsicWidth(), myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);

                } else if (level < 7) {
                    imageViewMonster.setImageResource(R.drawable.ui_fire_lion_2);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_firelion2);
                    myThumb.setBounds(new Rect(0, 0, myThumb.getIntrinsicWidth(), myThumb.getIntrinsicHeight()));
                    seekBarLevel.setThumb(myThumb);

                } else {
                    imageViewMonster.setImageResource(R.drawable.ui_fire_lion_3);
                    Drawable myThumb = getResources().getDrawable(R.drawable.icon_firelion3);
                    myThumb.setBounds(new Rect(0, 0, myThumb.getIntrinsicWidth(), myThumb.getIntrinsicHeight()));
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

        ImageView retourFire = findViewById(R.id.back_fire);
        retourFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    public void fillTextView(MonsterModel firelion) {
        TextView textViewTitle = findViewById(R.id.tv_level);
        TextView textViewPower = findViewById(R.id.tv_stat_power);
        TextView textViewLife = findViewById(R.id.tv_stat_life);
        TextView textViewSpeed = findViewById(R.id.tv_stat_speed);
        TextView textViewStamina = findViewById(R.id.tv_stat_stamina);

        textViewTitle.setText(String.format(getString(R.string.level_info), firelion.getLevel()));
        textViewLife.setText(String.valueOf(firelion.getLife()));
        textViewSpeed.setText(String.valueOf(firelion.getSpeed()));
        textViewStamina.setText(String.valueOf(firelion.getStamina()));
        textViewPower.setText(String.valueOf(firelion.getPower()));
    }
}

