package projet.projetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class NouveauJeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //On applique les couleurs tu theme sombre si il est actif
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            setTheme(R.style.darkTheme);
        }
        else
        {
            setTheme(R.style.AppTheme);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_jeu);
    }

    public void sendMessage(View view)
    {
        //Lorsque le bouton valider est pressé, on créé une valeur de retour et on ferme l'activité
        Intent selectionPlateforme = new Intent();
        TextInputEditText textInputNomDuJeu = (TextInputEditText) findViewById(R.id.textInputNomDuJeu);
        String nomDuJeu = textInputNomDuJeu.getText().toString();
        selectionPlateforme.putExtra("NomDuJeu", nomDuJeu);
        setResult(01, selectionPlateforme);
        finish();
    }
}