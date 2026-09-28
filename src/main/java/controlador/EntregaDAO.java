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
        String consultaSQL = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, entrega.getIdPedido());
            statement.setInt(2, entrega.getIdRepartidor());
            statement.setDate(3, entrega.getFecha());
            statement.setTime(4, entrega.getHora());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        entrega.setIdEntrega(rs.getInt(1));
                    }
                }
                System.out.println("Entrega registrada exitosamente en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al registrar la entrega: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar la entrega en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
