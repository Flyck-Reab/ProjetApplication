package projet.projetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class NouveauJeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_jeu);
    }

    public void sendMessage(View view)
    {
        Intent selectionPlateforme = new Intent(this, SelectionPlateforme.class);
        TextInputEditText textInputNomDuJeu = (TextInputEditText) findViewById(R.id.textInputNomDuJeu);
        String nomDuJeu = textInputNomDuJeu.getText().toString();
        selectionPlateforme.putExtra("NomDuJeu", nomDuJeu);
        startActivity(selectionPlateforme);
    }
}
