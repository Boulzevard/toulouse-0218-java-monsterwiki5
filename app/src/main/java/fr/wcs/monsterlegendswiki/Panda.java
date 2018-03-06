package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Panda extends AppCompatActivity {

    private ImageView retourPanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda);

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
}
