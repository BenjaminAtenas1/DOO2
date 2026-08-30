package model;

public abstract class Pedido {
    private int idPedido;
    private String direccionEntrega;
    private String tipoDePedido;
    private double distanciaKm;
    private String nombreRepartidor;

    public Pedido(){
    }
    public Pedido(int idPedido, String direccionEntrega, String tipoDePedido, double distanciaKm){
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoDePedido = tipoDePedido;
        this.distanciaKm = distanciaKm;
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
    public String getTipoDePedido(){
        return tipoDePedido;
    }
    public void setTipoDePedido(String tipoDePedido){
        this.tipoDePedido = tipoDePedido;
    }
    public double getDistanciaKm(){
        return distanciaKm;
    }
    public void setDistanciaKm(double distanciaKm){
        this.distanciaKm = distanciaKm;
    }
    public String getNombreRepartidor() {
        return nombreRepartidor;
    }
    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }
    public void asignarRepartidor(){
        System.out.println("Se ha asignado al repartidor para el pedido " +idPedido);
    }
    public void mostrarResumen(){
    }
    public abstract void calcularTiempoEntrega();

    @Override
    public String toString(){
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega + " | Tipo de pedido: " + tipoDePedido;
    }
}
