package conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexionBD {
    private static String URL_CONEXION = "jdbc:mysql://localhost:3306/speedfast";
    private static String USUARIO = "root";
    private static String CLAVE = "";

    public static Connection conexionBD(){
        try{
            return DriverManager.getConnection(URL_CONEXION,USUARIO,CLAVE);
        }catch (SQLException e){
            System.err.println("Error al intentar conectar con base de datos: "+ e.getMessage());
            return null;
        }
    }
}
