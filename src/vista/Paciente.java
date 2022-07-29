package vista;

public class Paciente  extends Persona{

    private String eps;
    private String enfermedad;
    
    public Paciente(){       
    }

    public Paciente(String eps, String enfermedad, String nombre, Long numeroCedula, int edad, String ciudad) {
        super(nombre, numeroCedula, edad, ciudad);
        this.eps = eps;
        this.enfermedad = enfermedad;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }    
    
    public String clasificarEdad(int edadConsulta, Long cedula) {
            String salida = "";
            if (edadConsulta >= 21 && edadConsulta <= 30) {
                return salida = "Cedula: " +cedula+ " - Joven adulto";
            } else if (edadConsulta > 30 && edadConsulta <= 60) {
                return salida = "Cedula: " +cedula + " - Adulto";
            } else {
               return salida = "Cedula: " +cedula + " - Tercera edad";
            }            
        }             
}
