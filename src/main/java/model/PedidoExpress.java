package model;

import java.util.ArrayList;

public class PedidoExpress extends Pedido{
    private String productoPedido;
    private String comercioAsignado;

    public PedidoExpress(){
    }
    public PedidoExpress(int idPedido, String direccionEntrega, String tipoDePedido, String productoPedido, String comercioAsignado, double distanciaKm) {
        super(idPedido, direccionEntrega, tipoDePedido, distanciaKm);
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
        System.out.println("El pedido Express " + getIdPedido() + " ha sido asignado exitosamente");
    }
    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor){
        setNombreRepartidor(nombreRepartidor);
        System.out.println("El pedido express " + getIdPedido() + " ha sido asignado al repartidor " + nombreRepartidor);
    }
    @Override
    public void mostrarResumen(){
        System.out.println("ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + getTipoDePedido() + " | Lista pedido: " + productoPedido + " | Comercio asignado: " + comercioAsignado + " | Distancia: " + getDistanciaKm() + " KM.");
    }

    @Override
    public void calcularTiempoEntrega(){
        double tiempoEntrega = 10;
        if (getDistanciaKm() > 5){
            tiempoEntrega += 5;
        }
        System.out.println("El tiempo de entrega del pedido es de: " + tiempoEntrega);
    }

    @Override
    public String toString() {
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + getTipoDePedido() + " | Lista pedido: " + productoPedido + " | Comercio asignado: " + comercioAsignado;
    }
}
