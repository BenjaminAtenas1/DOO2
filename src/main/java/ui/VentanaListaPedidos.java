package ui;

import gestores.ZonaDeCarga;
import interfaces.EstadoPedido;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private ZonaDeCarga zonaDeCarga;

    public VentanaListaPedidos(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;

        setTitle("Listado y Gestión de Envíos");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Dirección", "Tipo", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnIniciarEntrega = new JButton("Asignar repartidor / Iniciar entrega");
        JButton btnRefrescar = new JButton("Refrescar Lista");

        panelBotones.add(btnIniciarEntrega);
        panelBotones.add(btnRefrescar);
        add(panelBotones, BorderLayout.SOUTH);

        btnIniciarEntrega.addActionListener(e -> iniciarEntregaPedidoSeleccionado());
        btnRefrescar.addActionListener(e -> refrescarTabla());
        refrescarTabla();
    }

    private void iniciarEntregaPedidoSeleccionado() {
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idPedido = (int) tabla.getValueAt(filaSeleccionada, 0);
        Pedido pedido = zonaDeCarga.obtenerPedidoPorId(idPedido);
        if (pedido == null) return;
        if (pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {
            JOptionPane.showMessageDialog(this, "El pedido seleccionado ya está en proceso o fue entregado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        new Thread(() -> {
            try {
                pedido.setEstadoPedido(EstadoPedido.EN_REPARTO);
                SwingUtilities.invokeLater(this::refrescarTabla);
                System.out.println("Repartidor asignado. Pedido " + pedido.getIdPedido() + " en reparto...");
                Thread.sleep(2000);
                pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
                SwingUtilities.invokeLater(this::refrescarTabla);
                System.out.println("¡Pedido " + pedido.getIdPedido() + " entregado exitosamente!");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void refrescarTabla() {
        modeloTabla.setRowCount(0);
        List<Pedido> historial = zonaDeCarga.getHistorialPedidos();

        for (Pedido p : historial) {
            String nombrePedido = "Pedido General";

            if (p instanceof PedidoComida) {
                nombrePedido = "Pedido comida";
            } else if (p instanceof PedidoExpress) {
                nombrePedido = "Pedido express";
            } else if (p instanceof PedidoEncomienda) {
                nombrePedido = "Pedido encomienda";
            }
            modeloTabla.addRow(new Object[]{
                    p.getIdPedido(),
                    p.getDireccionEntrega(),
                    nombrePedido,
                    p.getEstadoPedido()
            });
        }
    }
}