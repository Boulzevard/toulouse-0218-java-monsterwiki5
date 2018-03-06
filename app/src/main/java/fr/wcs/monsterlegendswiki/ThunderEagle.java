package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThunderEagle extends AppCompatActivity {

    private ImageView retourThunderEagle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thunder_eagle);

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
}
