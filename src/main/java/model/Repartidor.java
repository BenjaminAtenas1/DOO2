package model;

import gestores.ZonaDeCarga;

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
        while(!Thread.currentThread().isInterrupted()){
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null){
                try{
                    System.out.println("Esperando más pedidos...");
                    Thread.sleep(1500);
                    break;

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Proceso interrumpido.");
                }

            }
        }
        System.out.println("Todos los pedidos han sido entregados correctamente.");
    }
}
