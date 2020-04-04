package projet.projetapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqliteoperations.myDbAdapter;

import java.util.jar.Attributes;

public class SelectionPlateforme extends AppCompatActivity {

    private EditText Pass, delete;
    private TextView nomJeu;
    private myDbAdapter helper;
    private RadioGroup plateFormeGroup;
    private RadioButton plateFormeButton;

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
        setContentView(R.layout.activity_selection_plateforme);

        //On sotck les éléments graphiques dans des attributs
        nomJeu = (TextView)findViewById(R.id.nomJeu);
        plateFormeGroup = (RadioGroup)findViewById(R.id.PlateFormeGroup);
        helper = new myDbAdapter(this);
    }

    //demande de saisir du nom d'un jeu
    public void saisirJeu(View view)
    {
        Intent saisieJeu = new Intent(SelectionPlateforme.this, NouveauJeu.class);
        startActivityForResult(saisieJeu, 01);
    }

    //Retour de la demande de nom du jeu
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==01)
        {
            try
            {
                String nomDuJeu = data.getStringExtra("NomDuJeu");
                nomJeu.setText(nomDuJeu);
            }
            catch (Exception e)
            {
                //Empty
            }
        }
    }

    //Valiation de l'ajout
    public void ajouterJeu(View v) {


        String nom = nomJeu.getText().toString();
        int selectedId=plateFormeGroup.getCheckedRadioButtonId();
        plateFormeButton  =(RadioButton)findViewById(selectedId);

        if(nom.isEmpty()) {
            Toast.makeText(v.getContext(), R.string.ToastNomJeuVide, Toast.LENGTH_SHORT).show();
        } else {
            // Insertion des données dans la table
            long id = helper.insertData(nom, plateFormeButton.getText().toString());

            //On vérifie si l'insertion s'est déroulé correctement
            if(id<=0) {
                Toast.makeText(v.getContext(), R.string.ToastErreurInsertion, Toast.LENGTH_SHORT).show();
                nomJeu.setText("");
            } else {
                Toast.makeText(v.getContext(), R.string.ToastInsertionReussie, Toast.LENGTH_SHORT).show();
                nomJeu.setText("");
                startActivity(new Intent(SelectionPlateforme.this, AffichageJeux.class));
                finish();

            }
        }
    }



    public void viewdata(View view)
    {
        String data = helper.getData();
        Toast.makeText(view.getContext(), ""+ this, Toast.LENGTH_SHORT).show();
    }

}
