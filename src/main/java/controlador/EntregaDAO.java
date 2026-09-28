package controlador;

import conexion.ConexionBD;
import model.Entrega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EntregaDAO {
    public void guardar(Entrega entrega) {
        String consultaSQL = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, CURDATE(), CURTIME())";

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, entrega.getIdPedido());
            statement.setInt(2, entrega.getIdRepartidor());

            int filas = statement.executeUpdate();

            if (filas > 0) {
                try (ResultSet resultado = statement.getGeneratedKeys()) {
                    if (resultado.next()) {
                        entrega.setIdEntrega(resultado.getInt(1));
                    }
                }
                System.out.println("Entrega registrada exitosamente.");
            }

        } catch (SQLException e) {
            System.err.println("Error al registrar la entrega: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar la entrega", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
