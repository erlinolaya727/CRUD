package vista;

public class Persona {

    private String nombre;
    private Long numeroCedula;
    private int edad;
    private String ciudad;
    
    public Persona(){        
    }

    public Persona(String nombre, Long numeroCedula, int edad, String ciudad) {
        this.nombre = nombre;
        this.numeroCedula = numeroCedula;
        this.edad = edad;
        this.ciudad = ciudad;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Long numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
