
package vista;
import java.util.ArrayList;

public interface PacienteDao {
    public void crear(Paciente p);
    public void actualizar(Paciente p);
    public void eliminar(Long p);
    public Paciente buscarPaciente(Long id);  
    public ArrayList<Paciente> listaPacientes();
}
