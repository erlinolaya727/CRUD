package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conexion;

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\BD_Reto4.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
