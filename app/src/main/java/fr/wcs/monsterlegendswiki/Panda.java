package fr.wcs.monsterlegendswiki;

import android.content.Intent;
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

        seekBarLevel.setMax(20);

        final MyMonster monsterPanda = new MyMonster(1, 242, 81, 192, 100);

        fillTextView(monsterPanda);

        seekBarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int level = i;

                textViewValue.setText(String.valueOf(level));
                monsterPanda.evolution(level);
                fillTextView(monsterPanda);
                if (level == 0 ){
                    imageViewMonster.setImageResource(R.drawable.treezard_huevo);
                }
                else if (level < 4){
                    imageViewMonster.setImageResource(R.drawable.panda_1);
                }
                else if (level < 7){
                    imageViewMonster.setImageResource(R.drawable.panda_2);
                }
                else {
                    imageViewMonster.setImageResource(R.drawable.panda_3);
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
        textViewTitle.setText("Panda level : " + firelion.getmLevel());
        textViewLife.setText("Life : " + firelion.getmLife());
        textViewSpeed.setText("Speed : " + firelion.getmSpeed());
        textViewStamina.setText("Stamina : " + firelion.getmStamina());
        textViewPower.setText("Power : "   + firelion.getmPower());
    }
}
