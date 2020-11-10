package cl.inacap.salud.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.salud.R;
import cl.inacap.salud.dto.Paciente;

public class PacientesListAdapter extends ArrayAdapter<Paciente> {
    private List <Paciente> pacientes;
    private Activity activity;

    public PacientesListAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.pacientes = objects;
        this.activity = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.pacientes_list, null, true);
        TextView nombreP = fila.findViewById(R.id.nombre_pacient_pl);
        Paciente actual = pacientes.get(position);
        nombreP.setText(actual.getNombre());
        return fila;
    }
}
