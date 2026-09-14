package cl.duoc.app;


import gestores.ControladorDeEnvios;
import gestores.ZonaDeCarga;
import model.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //ControladorDeEnvios controlador1 = new ControladorDeEnvios(); //Añadido en tarea semana 3


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
        /*
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n SEMANA 4 ");
        */

        /*
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
         */

        //FALTA ACTUALIZAR SUBCLASES DE PEDIDO, Y EJECUTAR PASO 5 DE LA TAREA

        //SEMANA 5
        System.out.println("::..SEMANA 5..::");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        Pedido pedido1 = new PedidoExpress(1111, "Los pajarito 123");
        Pedido pedido2 = new PedidoComida(2222, "Los perros 123");
        Pedido pedido3 = new PedidoEncomienda(3333,"Los arboles 123");
        Pedido pedido4 = new PedidoExpress(4444,"Los animales 123");
        Pedido pedido5 = new PedidoComida(5555,"Las montañas 123");
        Pedido pedido6 = new PedidoEncomienda(6666, "Las murallas 123");

        Repartidor repartidor1 = new Repartidor("Juanito", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("Pedrito", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Fulanito", zonaDeCarga);

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);
        zonaDeCarga.agregarPedido(pedido6);

        Thread hilo1 = new Thread(repartidor1);
        Thread hilo2 = new Thread(repartidor2);
        Thread hilo3 = new Thread(repartidor3);

        hilo1.start();
        hilo2.start();
        hilo3.start();



    }
}
