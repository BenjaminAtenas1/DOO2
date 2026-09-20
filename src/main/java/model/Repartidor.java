package model;

import gestores.ZonaDeCarga;
import interfaces.EstadoPedido;

import java.util.ArrayList;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombreRepartidor;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor() {
    }
    public Repartidor(String nombreRepartidor, ZonaDeCarga zonaDeCarga) {
        this.nombreRepartidor = nombreRepartidor;
        this.zonaDeCarga = zonaDeCarga;
    }
    public String getNombreRepartidor() {
        return nombreRepartidor;
    }
    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    @Override
    public String toString() {
        return "Nombre repartidor: " + nombreRepartidor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Pedido pedido = zonaDeCarga.retirarPedido();
                if (pedido == null) {
                    System.out.println(nombreRepartidor + ": Proceso detenido.");
                    break;
                }
                pedido.setEstadoPedido(EstadoPedido.EN_REPARTO);
                System.out.println(nombreRepartidor + " retiró el pedido " + pedido.getIdPedido() + " y salió a repartir.");
                Thread.sleep(1000);
                pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
                System.out.println("¡" + nombreRepartidor + " entregó con éxito el pedido " + pedido.getIdPedido() + "!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nombreRepartidor + " fue interrumpido.");
        }
    }
}


