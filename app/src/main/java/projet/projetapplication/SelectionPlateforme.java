package projet.projetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqliteoperations.myDbAdapter;

import java.util.jar.Attributes;

public class SelectionPlateforme extends AppCompatActivity {

    private EditText Pass , updateold, updatenew, delete;
    private TextView nomJeu;
    private Button ajouter;
    private myDbAdapter helper;
    private RadioGroup plateFormeGroup;
    private RadioButton plateFormeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_plateforme);
        nomJeu = (TextView)findViewById(R.id.nomJeu);
        nomJeu.setText(getIntent().getStringExtra("NomDuJeu"));
        ajouter = (Button)findViewById(R.id.buttonAjout);
        plateFormeGroup = (RadioGroup)findViewById(R.id.PlateFormeGroup);

        helper = new myDbAdapter(this);
    }

    public void ajouterJeu(View v) {
        String nom = nomJeu.getText().toString();
        int selectedId=plateFormeGroup.getCheckedRadioButtonId();
        plateFormeButton=(RadioButton)findViewById(selectedId);

        if(nom.isEmpty()) {
            Toast.makeText(v.getContext(), "Erreur !", Toast.LENGTH_SHORT).show();
        } else {
            long id = helper.insertData(nomJeu, plateFormeButton);
            if(id<=0)
            {
                Toast.makeText(v.getContext(), "Erreur lors de l'insertion !", Toast.LENGTH_SHORT).show();
                nomJeu.setText("");
                plateFormeButton.setText("");
            } else
            {

                Toast.makeText(v.getContext(), "Insertion réussie !", Toast.LENGTH_SHORT).show();
                nomJeu.setText("");
                plateFormeButton.setText("");
                Intent k = new Intent(SelectionPlateforme.this, MainActivity.class);
                startActivity(k);
            }
        }
    }

    public void viewdata(View view)
    {
        String data = helper.getData();
        Toast.makeText(view.getContext(), ""+ this, Toast.LENGTH_SHORT).show();
    }

}
