package cl.inacap.salud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.salud.adapter.PacientesListAdapter;
import cl.inacap.salud.dao.PacientesDAO;
import cl.inacap.salud.dao.PacientesDAOSQLite;
import cl.inacap.salud.dto.Paciente;

public class ListaPacientesActivity extends AppCompatActivity{

    private List<Paciente> pacientes;
    private PacientesDAO pacienteDAO = new PacientesDAOSQLite(this);
    private ListView pacientesLV;
    private PacientesListAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        this.pacientes = this.pacienteDAO.getAll();
        this.pacientesLV = findViewById(R.id.pacientes_lv);
        this.adapter = new PacientesListAdapter(this,R.layout.pacientes_list,this.pacientes);
        this.pacientesLV.setAdapter(this.adapter);

        this.pacientesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Paciente paciente = pacientes.get(i);
                Intent intent = new Intent(ListaPacienteActivity.this
                        , PacienteViewActivity.class);
                intent.putExtra("paciente", paciente);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paciente);


        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    }

}
