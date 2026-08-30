package cl.duoc.app;


import gestores.ControladorDeEnvios;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ControladorDeEnvios controlador1 = new ControladorDeEnvios(); //Añadido en tarea semana 3

        Pedido pedidoEncomienda = new PedidoEncomienda(415263, "Pajaritos 2132, maipu",
                "Entrega encomienda", "Ropa", 30,30,40, 4.5);
        Pedido pedidoComida = new PedidoComida(748596, "Los arboles 6544, pudahuel",
                "Entra de comida", "Hamburguesa", true,30);
        Pedido pedidoExpress = new PedidoExpress(987654, "Los perros 857485, santiago",
                "Entrega express", "tomates", "Supermercado Lider",6);

        //Metodo de sobrescritura encomienda
        pedidoEncomienda.asignarRepartidor();
        //Metodo de sobrecarga encomienda
        ((PedidoEncomienda)pedidoEncomienda).asignarRepartidor("Juanito perez");

        System.out.println("\n");

        //Metodo de sobrescritura pedido comida
        pedidoComida.asignarRepartidor();
        //Metodo de sobrecarga pedido de comida
        ((PedidoComida)pedidoComida).asignarRepartidor("Pedrito");

        System.out.println("\n");

        //Metodo de sobrescritura pedido express
        pedidoExpress.asignarRepartidor();
        //MEtodo de sobrecarga pedido express
        ((PedidoExpress)pedidoExpress).asignarRepartidor("John cena");

        //Acá comienza lo aprendido en la semana 2

        /*System.out.println("\n..::Pedido de Encomienda::..");
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.calcularTiempoEntrega();

        System.out.println("\n..::Pedido de comida::..");
        pedidoComida.mostrarResumen();
        pedidoComida.calcularTiempoEntrega();

        System.out.println("\n..::Pedido Express::..");
        pedidoExpress.mostrarResumen();
        pedidoExpress.calcularTiempoEntrega();

        LO DE LA SEMANA ANTERIOR HA SIDO OMITIDO PARA HACER LO MISMO PERO A TRAVES DE LAS INTERFACES Y EL CONTROLADOR
        DE ENVIOS
        */

        //Ejemplo de uso de interface Despachable
        System.out.println("\nDespacho de pedidos\n");
        controlador1.agregarPedido(pedidoEncomienda);
        controlador1.agregarPedido(pedidoExpress);
        controlador1.agregarPedido(pedidoComida);

        controlador1.despachar();


        //Ejemplo básico de cancelar un pedido con la interface Cancelable
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIngrese el pedido que desea cancelar: ");
        int idPedido = entrada.nextInt();

        controlador1.cancelar(idPedido);

        //Ejemplo de uso de interface Rastreable (si en el paso anterior eliminamos un pedido, en este historial el pedido
        //seleccionado no aparecerá)

        System.out.println(" ");
        controlador1.verHistorial();
    }
}