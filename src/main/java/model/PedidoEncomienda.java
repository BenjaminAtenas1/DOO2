package model;

public class PedidoEncomienda extends Pedido{
    private String encomienda;
    private int alturaCentimetros;
    private int anchoCentimetros;
    private int largoCentimetros;

    public PedidoEncomienda(){
    }
    public PedidoEncomienda(int idPedido, String direccionEntrega, String tipoDePedido, String encomienda, int alturaCentimetros, int anchoCentimetros, int largoCentimetros) {
        super(idPedido, direccionEntrega, tipoDePedido);
        this.encomienda = encomienda;
        this.alturaCentimetros = alturaCentimetros;
        this.anchoCentimetros = anchoCentimetros;
        this.largoCentimetros = largoCentimetros;
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
        System.out.println("La encomienda " + encomienda + " con ID " + idPedido + " ha sido asignado exitosamente");
    }
    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor, String vehiculo){
        System.out.println("La encomienda " + idPedido + " ha sido asignado al repartidor " + nombreRepartidor
                + " ya que su " + vehiculo + " permite transportar encomiendas.");
    }
    @Override
    public String toString(){
        return "ID Pedido: " + idPedido + " | Direccion de entrega: " + direccionEntrega + " | Tipo de pedido: " + tipoDePedido
                + " | Encomienda: " + encomienda + " | Altura: " + alturaCentimetros + " cm | Ancho: " + anchoCentimetros
                + " cm | Largo: " + largoCentimetros + " cm.";
    }
}
