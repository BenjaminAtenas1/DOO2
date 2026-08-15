package model;

public class Pedido {
    protected int idPedido;
    protected String direccionEntrega;
    protected String tipoDePedido;

    public Pedido(){
    }
    public Pedido(int idPedido, String direccionEntrega, String tipoDePedido){
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoDePedido = tipoDePedido;
    }
    public int getIdPedido(){
        return idPedido;
    }
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    public String direccionEntrega(){
        return direccionEntrega;
    }
    public void setDireccionEntrega(String direccionEntrega){
        this.direccionEntrega = direccionEntrega;
    }
    public String getTipoDePedido(){
        return tipoDePedido;
    }
    public void setTipoDePedido(String tipoDePedido){
        this.tipoDePedido = tipoDePedido;
    }
    public void asignarRepartidor(){
        System.out.println("Se ha asignado al repartidor para el pedido " +idPedido);
    }
    @Override
    public String toString(){
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega + " | Tipo de pedido: " + tipoDePedido;
    }
}
