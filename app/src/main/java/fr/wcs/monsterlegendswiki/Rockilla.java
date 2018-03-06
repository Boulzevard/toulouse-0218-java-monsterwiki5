package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Rockilla extends AppCompatActivity {

    private ImageView retourRockilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockilla);

        this.retourRockilla = findViewById(R.id.retour_rockilla);

        retourRockilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour4 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour4);
                finish();
            }
        });
    }
}
