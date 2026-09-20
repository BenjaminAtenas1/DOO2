package model;

import interfaces.EstadoPedido;

import java.util.ArrayList;

public class PedidoExpress extends Pedido{
    private String productoPedido;
    private String comercioAsignado;

    public PedidoExpress(){
    }
    public PedidoExpress(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega);
    }
    public String getListaPedido() {
        return productoPedido;
    }
    public void setListaPedido(String listaPedido) {
        this.productoPedido = listaPedido;
    }
    public String getComercioAsignado() {
        return comercioAsignado;
    }
    public void setComercioAsignado(String comercioAsignado) {
        this.comercioAsignado = comercioAsignado;
    }
    //Sobrescritura del método
    @Override
    public void asignarRepartidor(){
        System.out.println("El pedido Express " + getIdPedido() + " ha sido asignado exitosamente");
    }
    @Override
    public String toString() {
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                 + " | Lista pedido: " + productoPedido + " | Comercio asignado: " + comercioAsignado;
    }
}
