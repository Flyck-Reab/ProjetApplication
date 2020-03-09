package projet.projetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        ajouter = (Button)findViewById(R.id.buttonAjout);
        plateFormeGroup = (RadioGroup)findViewById(R.id.PlateFormeGroup);

        helper = new myDbAdapter(this);
    }

    public void ajouterJeu(View v) {
        String nom = nomJeu.getText().toString();
        if(nom.isEmpty()) {
            Toast.makeText(v.getContext(), "Erreur !", Toast.LENGTH_SHORT).show();
        } else {
            long id = helper.insertData(nomJeu);
            if(id<=0)
            {
                Toast.makeText(v.getContext(), "Erreur lors de l'insertion !", Toast.LENGTH_SHORT).show();
                Pass.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                Attributes.Name.setText("");
                Pass.setText("");
            }
        }
    }
}
