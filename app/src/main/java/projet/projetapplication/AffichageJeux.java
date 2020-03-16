package projet.projetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqliteoperations.myDbAdapter;

public class AffichageJeux extends AppCompatActivity {

    private TableLayout tableLayout;
    private myDbAdapter helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_jeux);


        tableLayout=(TableLayout)findViewById(R.id.tableLayout);

        helper = new myDbAdapter(this);

        TextView affichage = (TextView)findViewById(R.id.name);
        affichage.setText(helper.getData());
    }

    // Effacer les données si l'utilisateur appuie sur le bouton
    public void effacerDonnees(View v) {
        helper.deleteData();
        recreate();
        Toast.makeText(this.getApplicationContext(), "Données effacées !", Toast.LENGTH_SHORT).show();
    }

}
