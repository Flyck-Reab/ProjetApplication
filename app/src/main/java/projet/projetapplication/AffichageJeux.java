package projet.projetapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

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

}
