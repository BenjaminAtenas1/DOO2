package cl.duoc.app;


import gestores.ControladorDeEnvios;
import model.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ControladorDeEnvios controlador1 = new ControladorDeEnvios(); //Añadido en tarea semana 3

        Pedido pedidoEncomienda = new PedidoEncomienda(415263, "Pajaritos 2132, maipu",
                "Entrega encomienda", "Ropa", 30, 30, 40, 4.5);
        Pedido pedidoComida = new PedidoComida(748596, "Los arboles 6544, pudahuel",
                "Entra de comida", "Hamburguesa", true, 30);
        Pedido pedidoExpress = new PedidoExpress(987654, "Los perros 857485, santiago",
                "Entrega express", "tomates", "Supermercado Lider", 6);

        //Metodo de sobrescritura encomienda
        pedidoEncomienda.asignarRepartidor();
        //Metodo de sobrecarga encomienda
        ((PedidoEncomienda) pedidoEncomienda).asignarRepartidor("Juanito perez");

        System.out.println("\n");

        //Metodo de sobrescritura pedido comida
        pedidoComida.asignarRepartidor();
        //Metodo de sobrecarga pedido de comida
        ((PedidoComida) pedidoComida).asignarRepartidor("Pedrito");

        System.out.println("\n");

        //Metodo de sobrescritura pedido express
        pedidoExpress.asignarRepartidor();
        //MEtodo de sobrecarga pedido express
        ((PedidoExpress) pedidoExpress).asignarRepartidor("John cena");

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
        //Scanner entrada = new Scanner(System.in);
        //System.out.print("\nIngrese el pedido que desea cancelar: ");
        //int idPedido = entrada.nextInt();

        //controlador1.cancelar(idPedido);

        //Ejemplo de uso de interface Rastreable (si en el paso anterior eliminamos un pedido, en este historial el pedido
        //seleccionado no aparecerá)

        //System.out.println(" ");
        //controlador1.verHistorial();

        //Semana 4
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n SEMANA 4 ");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Pedido pedidoEncomienda1 = new PedidoEncomienda(1111, "Pajaritos 2132, maipu",
                "Entrega encomienda", "Ropa", 30, 30, 40, 4.5);
        Pedido pedidoComida1 = new PedidoComida(2222, "Los arboles 6544, pudahuel",
                "Entra de comida", "Hamburguesa", true, 30);
        Pedido pedidoExpress1 = new PedidoExpress(3333, "Los perros 857485, santiago",
                "Entrega express", "tomates", "Supermercado Lider", 6);
        Pedido pedidoEncomienda2 = new PedidoEncomienda(4444, "Pajaritos 2132, maipu",
                "Entrega encomienda", "Ropa", 30, 30, 40, 4.5);
        Pedido pedidoComida2 = new PedidoComida(5555, "Los arboles 6544, pudahuel",
                "Entra de comida", "Hamburguesa", true, 30);
        Pedido pedidoExpress2 = new PedidoExpress(6666, "Los perros 857485, santiago",
                "Entrega express", "tomates", "Supermercado Lider", 6);


        ArrayList<Pedido> listaRepartidor1 = new ArrayList<>();
        listaRepartidor1.add(pedidoEncomienda1);
        listaRepartidor1.add(pedidoEncomienda2);
        Repartidor repartidor1 = new Repartidor("Juan perez", listaRepartidor1);

        ArrayList<Pedido> listaRepartidor2 = new ArrayList<>();
        listaRepartidor2.add(pedidoComida1);
        listaRepartidor2.add(pedidoComida2);
        Repartidor repartidor2 = new Repartidor("Pedrito", listaRepartidor2);


        ArrayList<Pedido> listaRepartidor3 = new ArrayList<>();
        listaRepartidor2.add(pedidoExpress1);
        listaRepartidor2.add(pedidoExpress2);
        Repartidor repartidor3 = new Repartidor("Monchito", listaRepartidor3);

        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
