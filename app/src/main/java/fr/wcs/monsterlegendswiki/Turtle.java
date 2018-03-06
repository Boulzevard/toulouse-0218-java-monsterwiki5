package fr.wcs.monsterlegendswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Turtle extends AppCompatActivity {

    private ImageView retourTurtle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turtle);

        this.retourTurtle = findViewById(R.id.retour_turtle);

        retourTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retour3);
                finish();
            }
        });
    }
}
