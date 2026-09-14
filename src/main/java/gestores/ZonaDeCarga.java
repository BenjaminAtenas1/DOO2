package gestores;

import interfaces.EstadoPedido;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {
    private List<Pedido> listaPedidos;
    private volatile boolean continuar = true;

    public ZonaDeCarga() {
        this.listaPedidos = new ArrayList<>();
    }

    public synchronized void agregarPedido(Pedido pedido) {
        //Los pedidos entrarán como pendientes todos.

        try {
            if (pedido != null) {
                listaPedidos.add(pedido);
                System.out.println("Pedido recibido...");
                Thread.sleep(1000);
                System.out.println("Pedido: " + pedido.getIdPedido() + " listo para ser repartido.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Proceso interrumpido.");
        }
    }

    public synchronized Pedido retirarPedido() {
        try {
            while (continuar) {
                if (listaPedidos.isEmpty()) {
                    System.out.println("No hay más pedidos pendientes");
                    detenerProceso();
                }
                if (!listaPedidos.isEmpty()) {
                    Pedido pedido = listaPedidos.remove(0);
                    System.out.println(" ");
                    pedido.setEstadoPedido(EstadoPedido.EN_REPARTO);
                    System.out.println("Pedido retirado por repartidor. Pedido en reparto...");
                    Thread.sleep(1000);
                    pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
                    System.out.println("¡Pedido " + pedido.getIdPedido() + " entregado exitosamente!");
                    System.out.println(" ");
                    return pedido;
                } else {
                    System.out.println("No hay pedidos pendientes.");
                    return null;
                }

        }} catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Proceso interrumpido.");
            return null;
        }
        return null;
    }

    public void detenerProceso(){
        continuar = false;
    }
}


