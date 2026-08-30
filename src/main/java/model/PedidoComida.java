package model;

public class PedidoComida extends Pedido{
    private String tipoDePedido;
    private boolean incluyeBebestible;

    public PedidoComida(String hamburguesa, boolean b){
    }
    public PedidoComida(int idPedido, String direccionEntrega, String tipoDePedido, String comidaPedida, boolean incluyeBebestible, double distanciaKm){
        super(idPedido, direccionEntrega, comidaPedida, distanciaKm);
        this.tipoDePedido = comidaPedida;
        this.incluyeBebestible = incluyeBebestible;
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
    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor){
        setNombreRepartidor(nombreRepartidor);
        System.out.println("El pedido de comida " + getIdPedido() + " ha sido asignado al repartidor " + nombreRepartidor);
    }

    @Override
    public void mostrarResumen(){
        System.out.println("ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + getTipoDePedido() + " | Comida pedida: " + tipoDePedido + " | Incluye bebestible: " + incluyeBebestible + " | Distancia: " + getDistanciaKm() + " KM.");
    }

    @Override
    public void calcularTiempoEntrega(){
        double tiempoEntrega = 15 + (2 * getDistanciaKm());
        if (tiempoEntrega > 60){
            int horas = 1;
            tiempoEntrega = tiempoEntrega - 60;

            System.out.println("El tiempo de entrega del pedido es de: " + horas + " hora y " + tiempoEntrega + " minutos.");
        }else {
            System.out.println("El tiempo de entrega del pedido es de: " + tiempoEntrega + " minutos.");
        }
    }

    @Override
    public String toString(){
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: "
                + getTipoDePedido() + " | Comida pedida: " + tipoDePedido + " | Incluye bebestible: " + incluyeBebestible;
    }
}
