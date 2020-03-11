package projet.projetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.sqliteoperations.myDbAdapter;

class affichageJeux extends AppCompatActivity {

    private myDbAdapter.myDbHelper myhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_jeux);
        Intent i = new Intent(MainActivity.this, DisplayActivity.class);
    }

}
