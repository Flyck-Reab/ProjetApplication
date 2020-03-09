package projet.projetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity<myDbAdapter> extends AppCompatActivity {

    private EditText Pass , updateold, updatenew, delete;
    private TextView nomJeu;
    private Button ajouter;
    private myDbAdapter helper;
    private RadioGroup plateFormeGroup;
    private RadioButton plateFormeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Toast.makeText()
                Pass.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                Attributes.Name.setText("");
                Pass.setText("");
            }
        }
    }

    public void sendMessage(View view)
    {
        startActivity(new Intent(MainActivity.this,NouveauJeu.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_threedots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuAnglais:
                break;
            case R.id.menuFrancais:
                break;
        }
        return true;
    }
}
