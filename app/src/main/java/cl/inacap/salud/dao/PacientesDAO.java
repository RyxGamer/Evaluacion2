package cl.inacap.salud.dao;

import java.util.List;
import cl.inacap.salud.dto.Paciente;

public interface PacientesDAO {

    Paciente save(Paciente p);
    List<Paciente> getAll();


}
