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
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
            { setTheme(R.style.AppTheme); }
        else
            { setTheme(R.style.darkTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void sendMessage(View view) {

        switch (view.getId()) {
            case R.id.buttonStart:
                startActivity(new Intent(MainActivity.this, NouveauJeu.class));
                break;
            case R.id.buttonListeJeux:
                startActivity(new Intent(MainActivity.this, AffichageJeux.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view);
        }
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
            case R.id.theme:
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setTheme(R.style.darkTheme);
                }
                Toast message;
                String texte = "Changement de theme";
                message = Toast.makeText(this.getApplicationContext(),texte, Toast.LENGTH_SHORT);
                message.show();


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return true;
    }


}
