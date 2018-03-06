package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class FireLion extends AppCompatActivity {

    private ImageView retourFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_lion);

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
}

