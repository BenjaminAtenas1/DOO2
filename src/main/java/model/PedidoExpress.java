package model;

import java.util.ArrayList;

public class PedidoExpress extends Pedido{
    private String productoPedido;
    private String comercioAsignado;

    public PedidoExpress(){
    }
    public PedidoExpress(int idPedido, String direccionEntrega, String tipoDePedido, String productoPedido, String comercioAsignado) {
        super(idPedido, direccionEntrega, tipoDePedido);
        this.productoPedido = productoPedido;
        this.comercioAsignado = comercioAsignado;
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
        System.out.println("El pedido Express " + idPedido + " ha sido asignado exitosamente");
    }
    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor, int metrosDeCercania){
        System.out.println("El pedido express " + idPedido + " ha sido asignado al repartidor " + nombreRepartidor
                + " ya que su cercanía de " + metrosDeCercania + " mts permite hacer una entrega más rápida.");
    }
    @Override
    public String toString() {
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega + " | Tipo de pedido: "
                + tipoDePedido + " | Lista pedido: " + productoPedido + " | Comercio asignado: " + comercioAsignado;
    }
}
