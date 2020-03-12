package projet.projetapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AffichageJeux extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_jeux);
        tableLayout=(TableLayout)findViewById(R.id.tableLayout);


        data.moveToFirst();
        do {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.activity_affichage_jeux,null,false);
            TextView name = (TextView)tableRow.findViewById(R.id.name);
            TextView title = (TextView)tableRow.findViewById(R.id.title);

            name.setText(data.getString(1));
            title.setText(data.getString(2));
            tableLayout.addView(tableRow);
        } while (data.moveToNext());
        data.close();
    }
}
