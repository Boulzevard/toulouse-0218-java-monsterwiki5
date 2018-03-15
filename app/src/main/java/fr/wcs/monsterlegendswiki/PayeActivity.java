package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PayeActivity extends AppCompatActivity {

    private ImageView retour;
    private EditText email;
    private EditText card;
    private EditText date;
    private EditText crypto;
    private Button valide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paye);

        email = findViewById(R.id.editText_email);
        card = findViewById(R.id.editText_card);
        date = findViewById(R.id.editText_date);
        crypto = findViewById(R.id.editText_crypto);
        valide = findViewById(R.id.button_validation);

        valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PayeActivity.this, "Carte Non Valide", Toast.LENGTH_LONG).show();
            }
        });







        this.retour = findViewById(R.id.imageView_retour);


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour1);
                finish();
            }
        });

    }
}
