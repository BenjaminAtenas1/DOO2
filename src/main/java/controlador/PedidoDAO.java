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

        String tipoPedido = "EXPRESS";
        if (pedido instanceof PedidoComida) {
            tipoPedido = "COMIDA";
        } else if (pedido instanceof PedidoEncomienda) {
            tipoPedido = "ENCOMIENDA";
        }

        if (pedido.getEstadoPedido() == null) {
            pedido.setEstadoPedido(EstadoPedido.PENDIENTE);
        }

        try (Connection conexion = ConexionBD.conexionBD();
             PreparedStatement statement = conexion.prepareStatement(consultaSQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, pedido.getDireccionEntrega());
            statement.setString(2, tipoPedido);
            statement.setString(3, pedido.getEstadoPedido().name());

            int filas = statement.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        pedido.setIdPedido(idGenerado);
                    }
                }
                JOptionPane.showMessageDialog(null, "Pedido guardado con éxito.");
            }

        } catch (SQLException e) {
            System.err.println("Error al guardar pedido: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
