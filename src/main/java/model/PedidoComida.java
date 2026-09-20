package model;

import interfaces.EstadoPedido;

public class PedidoComida extends Pedido{
    private String tipoDePedido;
    private boolean incluyeBebestible;

    public PedidoComida(String hamburguesa, boolean b){
    }
    public PedidoComida(int idPedido, String direccionEntrega){
        super(idPedido, direccionEntrega);
    }
    public String getComidaPedida() {
        return tipoDePedido;
    }
    public void setComidaPedida(String comidaPedida) {
        this.tipoDePedido = comidaPedida;
    }
    public boolean isIncluyeBebestible() {
        return incluyeBebestible;
    }
    public void setIncluyeBebestible(boolean incluyeBebestible) {
        this.incluyeBebestible = incluyeBebestible;
    }
    //Sobrescritura del método
    @Override
    public void asignarRepartidor(){
        System.out.println("El pedido de " + tipoDePedido + " con ID " + getIdPedido() + " ha sido asignado exitosamente");
    }

    @Override
    public String toString(){
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + " | Comida pedida: " + tipoDePedido + " | Incluye bebestible: " + incluyeBebestible;
    }
}
