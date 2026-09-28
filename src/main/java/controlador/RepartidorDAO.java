package controlador;


import conexion.ConexionBD;
import model.Repartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {
    public List<Repartidor> listarTodos() {
        List<Repartidor> listaRepartidores = new ArrayList<>();
        String consultaSQL = "SELECT * FROM repartidor";

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                // Leemos el nombre de la columna 'nombre' de la BD
                String nombre = resultado.getString("nombre");

                // Instanciamos el objeto Repartidor y le asignamos el nombre
                Repartidor repartidor = new Repartidor();
                repartidor.setNombreRepartidor(nombre);

                // Agregamos el objeto a la lista
                listaRepartidores.add(repartidor);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar los repartidores: " + e.getMessage());
        }

        return listaRepartidores;
    }
}
