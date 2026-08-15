package model;

public class PedidoComida extends Pedido{
    private String comidaPedida;
    private boolean incluyeBebestible;

    public PedidoComida(String hamburguesa, boolean b){
    }
    public PedidoComida(int idPedido, String direccionEntrega, String tipoDePedido, String comidaPedida, boolean incluyeBebestible){
        super(idPedido, direccionEntrega, comidaPedida);
        this.comidaPedida = comidaPedida;
        this.incluyeBebestible = incluyeBebestible;
    }
    public String getComidaPedida() {
        return comidaPedida;
    }
    public void setComidaPedida(String comidaPedida) {
        this.comidaPedida = comidaPedida;
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
        System.out.println("El pedido de " + comidaPedida + " con ID " + idPedido + " ha sido asignado exitosamente");
    }
    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor, String tipoDeMochila){
        System.out.println("El pedido de comida " + idPedido + " ha sido asignado al repartidor " + nombreRepartidor
                + " ya que su tipo de mochila es " + tipoDeMochila);
    }
    @Override
    public String toString(){
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega + " | Tipo de pedido: "
                + tipoDePedido + " | Comida pedida: " + comidaPedida + " | Incluye bebestible: " + incluyeBebestible;
    }
}
