package fr.gsb;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class RechercherRvActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String [] lesmois = {"janvier", "février", "mars","avril","mai","juin","juillet", "août","septembre","octobre","novembre", "decembre"} ;
    private static final String [] lesannee = {"2024", "2023", "2022","2021","2020","2019","2018", "2017","2016","2015"} ;
Spinner selectmois ;
Spinner selectannee ;

TextView tvmois ;
TextView tvannee ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechercher_rv_activity);
        tvmois = (TextView) findViewById(R.id.tvmois) ;
        tvannee = (TextView) findViewById(R.id.tvannee);
        tvmois.setText("Mois :");
        tvannee.setText("Annee :");

        selectmois = (Spinner) findViewById(R.id.mois) ;
        selectannee = (Spinner) findViewById(R.id.annee) ;
        ArrayAdapter<String> aamois = new ArrayAdapter<String>( this , android.R.layout.simple_spinner_item , lesmois) ;
        ArrayAdapter<String> aanne = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , lesannee) ;
        aamois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aanne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectmois.setAdapter( aamois);
        selectannee.setAdapter(aanne);

    }




    public void afficherv(View vue) {
        String moisselectionne = selectmois.getSelectedItem().toString();
        String anneeselectionnee = selectannee.getSelectedItem().toString();

        Intent intent = new Intent(this, ListeRvActivity.class);
        intent.putExtra("mois", moisselectionne);
        intent.putExtra("annee", anneeselectionnee);
        startActivity(intent);
    }








    @Override
    public void onClick(View view) {

    }
}
