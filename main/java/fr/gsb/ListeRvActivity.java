package fr.gsb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import fr.gsb.rv.models.ModeleGsb;
import fr.gsb.rv.entites.rv ;


public class ListeRvActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView tvmoisannee;
    ListView lvRV ;

    private List<rv> lesRV ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister_rv_activity);

        tvmoisannee = findViewById(R.id.tvmoisannee);
        lvRV = findViewById(R.id.touslesrv) ;


        Bundle paquetmois = getIntent().getExtras();

        if (paquetmois != null) {
            String mois = paquetmois.getString("mois");
            String annee = paquetmois.getString("annee");
            tvmoisannee.setText("mois : " + mois + " annee : " + annee);

            lesRV = ModeleGsb.getInstance().getRV() ;

            for( rv unRV : lesRV ){
                if (unRV.getMois().equals(mois) && unRV.getAnnee().equals(annee) ){
                    
                    return ;
                    
                }


            }

            ArrayAdapter<rv> adaptateur = new ArrayAdapter<rv>(
               this ,
               android.R.layout.simple_list_item_1 ,
               lesRV
            ) ;

            lvRV.setAdapter( adaptateur ) ;



        } else {
            tvmoisannee.setText("mois : Non défini");
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
