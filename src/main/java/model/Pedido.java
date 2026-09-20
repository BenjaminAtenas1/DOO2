package model;
import interfaces.EstadoPedido;

public abstract class Pedido{
    private int idPedido;
    private String direccionEntrega;
    private volatile EstadoPedido estadoPedido;

    public Pedido(){
    }
    public Pedido(int idPedido, String direccionEntrega){
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.estadoPedido = EstadoPedido.PENDIENTE;
    }
    public int getIdPedido(){
        return idPedido;
    }
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    public String getDireccionEntrega(){
        return direccionEntrega;
    }
    public void setDireccionEntrega(String direccionEntrega){
        this.direccionEntrega = direccionEntrega;
    }
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void asignarRepartidor(){
        System.out.println("Se ha asignado al repartidor para el pedido " +idPedido);
    }

    public void mostrarResumen(){
    }

    @Override
    public String toString(){
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega;
    }

    public void setEstado(String estadoNuevo){

    }
}
