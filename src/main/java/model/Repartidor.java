package model;

import java.util.ArrayList;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombreRepartidor;
    private ArrayList<Pedido> listaPedidos;
    private Random tiempoAleatorio = new Random();

    public Repartidor() {
    }

    public Repartidor(String nombreRepartidor, ArrayList<Pedido> listaPedidos) {
        this.nombreRepartidor = nombreRepartidor;
        this.listaPedidos = listaPedidos;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Nombre repartidor: " + nombreRepartidor;
    }

    @Override
    public void run() {
        try {
            for (Pedido pedidos : listaPedidos) {
                System.out.println("Repartidor: " + nombreRepartidor + " | Pedido asignado: " + pedidos.getIdPedido() + " | Tipo pedido: " + pedidos.getClass().getSimpleName());
                System.out.println("Se inicia el recorrido...");
                int tiempo = tiempoAleatorio.nextInt(5000) + 500;
                Thread.sleep(tiempo);
                System.out.println("El repartidor está por llegar al domicilio...");
                Thread.sleep(tiempo);
                System.out.println("Pedido entregado exitosamente.");
            }
        } catch (InterruptedException e) {
            System.out.println("Entrega de pedido no completada");
            Thread.currentThread().interrupt();
            return;
        }
    }
}
