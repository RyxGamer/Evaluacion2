package cl.inacap.salud;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import cl.inacap.salud.dao.PacientesDAO;
import cl.inacap.salud.dao.PacientesDAOSQLite;
import cl.inacap.salud.dto.Paciente;

public class RegistrarPacienteActivity extends AppCompatActivity{

    private PacientesDAO pacienteDAO = new PacientesDAOSQLite(this);
    private EditText rutTxt, nombreTxt, apellidoTxt, temperaturaTxt, presionTxt, fechaTxt;
    private Spinner areaTxt;
    private Switch covidTxt, tosTxt;
    private Toolbar toolbar;
    private Button agregarBtn;
    private Calendar myCalendar = Calendar.getInstance();
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente_view);

        this.toolbar = findViewById(R.id.toolbar);
        this.rutTxt = findViewById(R.id.rut_txt);
        this.nombreTxt = findViewById(R.id.nombre_txt);
        this.apellidoTxt = findViewById(R.id.apellido_txt);
        this.fechaTxt = findViewById(R.id.fecha_txt);
        this.areaTxt = findViewById(R.id.area_spinner);
        String[] areas = {"Atencion a público","Otro"};
        areaTxt.setAdapter(new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,areas));
        this.covidTxt = findViewById(R.id.covid_switch_si);
        this.temperaturaTxt = findViewById(R.id.temperatura_txt);
        this.tosTxt = findViewById(R.id.tos_switch_si);
        this.presionTxt = findViewById(R.id.presion_txt);

        this.agregarBtn = findViewById(R.id.registrar_btn);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paciente p = new Paciente();

                p.setRut(rutTxt.getText().toString());
                p.setNombre(nombreTxt.getText().toString());
                p.setApellido(apellidoTxt.getText().toString());
                p.setArea(areaTxt.getSelectedItem().toString());
                p.setTemperatura(Integer.parseInt(temperaturaTxt.getText().toString()));
                p.setPresion(Integer.parseInt(presionTxt.getText().toString()));
                pacientDAO.save(p);
                startActivity(new Intent(RegistrarPacienteViewActivity.this
                        , ListaPacienteActivity.class));
            }
        });
    }
}
