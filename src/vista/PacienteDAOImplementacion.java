package vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PacienteDAOImplementacion extends Conexion implements PacienteDao {

    @Override
    public void crear(Paciente p) {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Pacientes "
                    + "(nombre,numeroCedula,edad,ciudad,eps,enfermedad) VALUES(?,?,?,?,?,?)");
            st.setString(1, p.getNombre());
            st.setLong(2, p.getNumeroCedula());
            st.setInt(3, p.getEdad());
            st.setString(4, p.getCiudad());
            st.setString(5, p.getEps());
            st.setString(6, p.getEnfermedad());
            st.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void actualizar(Paciente p) {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Pacientes SET nombre=?, edad=?, ciudad=?, eps=?, enfermedad=? WHERE numeroCedula=?");
            st.setString(1, p.getNombre());
            st.setInt(2, p.getEdad());
            st.setString(3, p.getCiudad());
            st.setString(4, p.getEps());
            st.setString(5, p.getEnfermedad());
            st.setLong(6, p.getNumeroCedula());
            st.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void eliminar(Long per) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Pacientes WHERE numeroCedula = ?");
            ps.setLong(1, per);
            ps.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Paciente buscarPaciente(Long id) {
        Paciente pac = new Paciente();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Pacientes WHERE numeroCedula=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac.setNombre(rs.getString("nombre"));
                pac.setNumeroCedula(rs.getLong("numeroCedula"));
                pac.setEdad(rs.getInt("edad"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setEps(rs.getString("eps"));
                pac.setEnfermedad(rs.getString("enfermedad"));
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.desconectar();
        }
        return pac;
    }

    @Override
    public ArrayList<Paciente> listaPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        try {
            this.conectar();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pacientes");
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setNombre(rs.getString("nombre"));
                pac.setNumeroCedula(rs.getLong("numeroCedula"));
                pac.setEdad(rs.getInt("edad"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setEps(rs.getString("eps"));
                pac.setEnfermedad(rs.getString("enfermedad"));
                pacientes.add(pac);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.desconectar();
        }
        return pacientes;
    }
}
