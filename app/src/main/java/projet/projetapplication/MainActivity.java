package projet.projetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

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
        setContentView(R.layout.activity_main);
    }


    //Lorsqu'un bouton est cliqué, la fonction est activée.
    public void sendMessage(View view) {
        switch (view.getId()) {
            //Si le bouton d'ajout de jeux est cliqué, on lance l'activité correspondante
            case R.id.buttonStart:
                startActivity(new Intent(MainActivity.this, SelectionPlateforme.class));
                break;
            //Si le bouton de visualisation de jeux est cliqué, on lance l'activité correspondante
            case R.id.buttonListeJeux:
                startActivity(new Intent(MainActivity.this, AffichageJeux.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //On rajoute le menu 3 points à la barre de menu
        getMenuInflater().inflate(R.menu.menu_threedots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Toast message;
        String texte;
        switch (id) {
            //si le bouton menu selectionné est le theme :
            case R.id.theme:
                //Si le theme sombre est actif, l'activer
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else

                //Si le theme sombre est inactif, il faut le desactiver
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setTheme(R.style.darkTheme);
                }

                //Message explicitant que le theme à changé
                texte = "Changement de theme";
                message = Toast.makeText(this.getApplicationContext(),texte, Toast.LENGTH_SHORT);
                message.show();


                break;
                //si l'item du menu selectionné est : la demande de version
            case R.id.version:
                texte = "Cette version est la V1";
                message = Toast.makeText(this.getApplicationContext(),texte, Toast.LENGTH_SHORT);
                message.show();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return true;
    }


}
