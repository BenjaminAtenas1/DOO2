package model;

import interfaces.EstadoPedido;

public class PedidoEncomienda extends Pedido{
    private String encomienda;
    private int alturaCentimetros;
    private int anchoCentimetros;
    private int largoCentimetros;

    public PedidoEncomienda(){
    }
    public PedidoEncomienda(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega);

    }
    public String getEncomienda() {
        return encomienda;
    }
    public void setEncomienda(String encomienda) {
        this.encomienda = encomienda;
    }
    public int getAlturaCentimetros() {
        return alturaCentimetros;
    }
    public void setAlturaCentimetros(int alturaCentimetros) {
        this.alturaCentimetros = alturaCentimetros;
    }
    public int getLargoCentimetros() {
        return largoCentimetros;
    }
    public void setLargoCentimetros(int largoCentimetros) {
        this.largoCentimetros = largoCentimetros;
    }
    public int getAnchoCentimetros() {
        return anchoCentimetros;
    }
    public void setAnchoCentimetros(int anchoCentimetros) {
        this.anchoCentimetros = anchoCentimetros;
    }
    //Sobrescritura del método
    @Override
    public void asignarRepartidor(){
        System.out.println("La encomienda " + encomienda + " con ID " + getIdPedido() + " ha sido asignado exitosamente");
    }

    @Override
    public String toString(){
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + " | Encomienda: " + encomienda + " | Altura: " + alturaCentimetros + " cm | Ancho: " + anchoCentimetros
                + " cm | Largo: " + largoCentimetros + " cm.";
    }
}
