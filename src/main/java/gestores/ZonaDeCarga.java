package gestores;

import interfaces.EstadoPedido;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {
    private List<Pedido> listaPedidos = new ArrayList<>();
    private List<Pedido> historialPedidos = new ArrayList<>();
    private volatile boolean continuar = true;


    public synchronized void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            listaPedidos.add(pedido);
            historialPedidos.add(pedido);
            System.out.println("Pedido recibido...");
            System.out.println("Pedido: " + pedido.getIdPedido() + " preparado y listo para ser repartido.");
            notifyAll();
        }
    }
    public synchronized Pedido retirarPedido() {
        while (listaPedidos.isEmpty() && continuar) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        if (!continuar && listaPedidos.isEmpty()) {
            return null;
        }
        return listaPedidos.remove(0);
    }

    public synchronized List<Pedido> getListaPedidos() {
        return new ArrayList<>(listaPedidos);
    }

    public synchronized Pedido obtenerPedidoPorId(int id) {
        for (Pedido p : historialPedidos) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        return null;
    }
    public synchronized List<Pedido> getHistorialPedidos(){
        return new ArrayList<>(historialPedidos);
    }
    public synchronized void detenerProceso() {
        this.continuar = false;
        notifyAll();
    }
}


