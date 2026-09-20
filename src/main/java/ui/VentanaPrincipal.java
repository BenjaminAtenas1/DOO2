package ui;

import gestores.ZonaDeCarga;
import model.Repartidor;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VentanaPrincipal extends JFrame{
    private ZonaDeCarga zonaDeCarga;

    public VentanaPrincipal() {
        this.zonaDeCarga = new ZonaDeCarga();

        setTitle("Sistema de Gestión de Envíos");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

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
    }
}