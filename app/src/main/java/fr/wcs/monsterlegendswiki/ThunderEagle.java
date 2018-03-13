package fr.wcs.monsterlegendswiki;

import android.content.Intent;
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

        seekBarLevel.setMax(20);

        final MyMonster monsterThunderEagle = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterThunderEagle);

        seekBarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int level = i;

                textViewValue.setText(String.valueOf(level));
                monsterThunderEagle.evolution(level);
                fillTextView(monsterThunderEagle);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.thunder_eagle_huevo);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.thundereagle_1);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.thundereagle_2);
                }
                else {
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
        textViewTitle.setText("Thunder Eagle level : " + firelion.getmLevel());
        textViewLife.setText("Life : " + firelion.getmLife());
        textViewSpeed.setText("Speed : " + firelion.getmSpeed());
        textViewStamina.setText("Stamina : " + firelion.getmStamina());
        textViewPower.setText("Power : "   + firelion.getmPower());
    }
}
