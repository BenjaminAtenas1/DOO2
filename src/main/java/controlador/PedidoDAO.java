package controlador;

import conexion.ConexionBD;
import interfaces.EstadoPedido;
import model.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import interfaces.EstadoPedido;


public class PedidoDAO {

    public void guardar(Pedido pedido) {
        String consultaSQL = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        // Determinamos el tipo de pedido según la instancia de la clase
        String tipoStr = "EXPRESS";
        if (pedido instanceof PedidoComida) {
            tipoStr = "COMIDA";
        } else if (pedido instanceof PedidoEncomienda) {
            tipoStr = "ENCOMIENDA";
        }

        // Si el estado es null en el objeto, le asignamos PENDIENTE por defecto
        if (pedido.getEstadoPedido() == null) {
            pedido.setEstadoPedido(EstadoPedido.PENDIENTE);
        }

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, pedido.getDireccionEntrega());
            statement.setString(2, tipoStr);
            // Convertimos el enum EstadoPedido a String usando .name()
            statement.setString(3, pedido.getEstadoPedido().name());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                // Recuperamos el ID autogenerado por MySQL y se lo asignamos al objeto Pedido
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        pedido.setIdPedido(idGenerado);
                    }
                }
                JOptionPane.showMessageDialog(null, "Pedido guardado con éxito en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al guardar pedido: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar el pedido en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarPedidos(DefaultTableModel tabla) {
        String consultaSQL = "SELECT * FROM pedido";

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL);
             ResultSet resultado = statement.executeQuery()) {

            tabla.setRowCount(0);

            while (resultado.next()) {
                tabla.addRow(new Object[]{
                        resultado.getInt("id"),
                        resultado.getString("direccion"),
                        resultado.getString("tipo"),
                        resultado.getString("estado")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de base de datos al cargar pedidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
