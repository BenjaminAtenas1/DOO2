package ui;

import gestores.ZonaDeCarga;
import model.Repartidor;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import conexion.ConexionBD;
import controlador.RepartidorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentanaPrincipal extends JFrame{
    private ZonaDeCarga zonaDeCarga;

    public VentanaPrincipal() {
        this.zonaDeCarga = new ZonaDeCarga();

        setTitle("Sistema de Gestión de Envíos");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));
        /*
        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar y Asignar Entregas");
        JButton btnSalir = new JButton("Salir");

        btnRegistrar.addActionListener(e -> {
            VentanaRegistroPedido vRegistro = new VentanaRegistroPedido(zonaDeCarga);
            vRegistro.setVisible(true);
        });

        btnListar.addActionListener(e -> {
            VentanaListaPedidos vLista = new VentanaListaPedidos(zonaDeCarga);
            vLista.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        add(btnRegistrar);
        add(btnListar);
        add(btnSalir);
        */

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnRegistrarRepartidor = new JButton("Registrar Repartidor");
        JButton btnListarPedidos = new JButton("Listar Pedidos");
        JButton btnSalir = new JButton("Salir");

        btnRegistrar.addActionListener(e -> {
            VentanaRegistroPedido vRegistro = new VentanaRegistroPedido();
            vRegistro.setVisible(true);
        });

        btnRegistrarRepartidor.addActionListener(e -> registrarNuevoRepartidor());

        btnListarPedidos.addActionListener(e -> {
            VentanaListaPedidos vLista = new VentanaListaPedidos();
            vLista.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        add(btnRegistrar);
        add(btnRegistrarRepartidor);
        add(btnListarPedidos);
        add(btnSalir);
    }

    private void registrarNuevoRepartidor() {
        String nombreRepartidor = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo repartidor:", "Registrar Repartidor", JOptionPane.QUESTION_MESSAGE);

        if (nombreRepartidor != null && !nombreRepartidor.trim().isEmpty()) {
            String consultaSQL = "INSERT INTO repartidor (nombre) VALUES (?)";

            try (Connection conexion = ConexionBD.conexionBD();
                 PreparedStatement statement = conexion.prepareStatement(consultaSQL)) {

                statement.setString(1, nombreRepartidor.trim());
                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Repartidor guardado exitosamente.");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el repartidor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}