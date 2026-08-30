package gestores;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {
    List<Pedido> listaPedidos = new ArrayList<>();
    List<Pedido> historialPedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }

    @Override
    public void despachar() {
        for (Pedido pedidos : listaPedidos){
            System.out.println("Despacho de pedido " + pedidos.getIdPedido());
            pedidos.calcularTiempoEntrega();
            historialPedidos.add(pedidos);
        }
    }

    @Override
    public void cancelar(int idPedido) {
        boolean eliminado = listaPedidos.removeIf(pedido -> pedido.getIdPedido() == idPedido);

        if (eliminado){
            System.out.println("El pedido " + idPedido + " ha sido eliminado correctamente.");
        }else{
            System.out.println("Pedido no encontrado");
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de pedidos completados:");
        for (Pedido pedidos : listaPedidos){
            System.out.println(getClass().getSimpleName() + " Nro " + pedidos.getIdPedido() + " entregado por: " + pedidos.getNombreRepartidor());
        }

    }
}
