package ui;

import gestores.ZonaDeCarga;
import model.*;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField campoId;
    private JTextField campoDireccion;
    private JComboBox<String> comboTipoPedido;
    private ZonaDeCarga zonaDeCarga;

    public VentanaRegistroPedido(ZonaDeCarga zonaDeCarga){
        this.zonaDeCarga = zonaDeCarga;

        setTitle("Registro nuevo pedido.");
        setSize(350,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2,5,5));

        add(new JLabel("ID Pedido:"));
        campoId = new JTextField();
        add(campoId);

        add(new JLabel("Direccion:"));
        campoDireccion = new JTextField();
        add(campoDireccion);

        add(new JLabel("Tipo de pedido:"));
        comboTipoPedido = new JComboBox<>(new String[]{"Express","Comida","Encomienda"});
        add(comboTipoPedido);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> guardarPedido());
        add(botonGuardar);
    }

    public void guardarPedido(){
        try{
            int id = Integer.parseInt(campoId.getText().trim());
            String direccion = campoDireccion.getText().trim();
            String tipo = (String)comboTipoPedido.getSelectedItem();

            if (campoDireccion.getText().trim().isEmpty() || campoId.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos","Error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Pedido pedido = null;
            switch (tipo){
                case "Express" -> pedido = new PedidoExpress(id, direccion);
                case "Comida" -> pedido = new PedidoComida(id, direccion);
                case "Encomienda" -> pedido = new PedidoEncomienda(id,direccion);
            }
            zonaDeCarga.agregarPedido(pedido);

            JOptionPane.showMessageDialog(this,"Pedido listo para reparto");
            dispose();
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Verifique la información ingresada","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
