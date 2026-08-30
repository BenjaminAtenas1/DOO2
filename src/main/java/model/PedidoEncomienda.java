package model;

public class PedidoEncomienda extends Pedido{
    private String encomienda;
    private int alturaCentimetros;
    private int anchoCentimetros;
    private int largoCentimetros;

    public PedidoEncomienda(){
    }
    public PedidoEncomienda(int idPedido, String direccionEntrega, String tipoDePedido, String encomienda, int alturaCentimetros, int anchoCentimetros, int largoCentimetros, double distanciaKm) {
        super(idPedido, direccionEntrega, tipoDePedido, distanciaKm);
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
        System.out.println("La encomienda " + encomienda + " con ID " + getIdPedido() + " ha sido asignado exitosamente");
    }

    //Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor){
        setNombreRepartidor(nombreRepartidor);
        System.out.println("La encomienda " + getIdPedido() + " ha sido asignado al repartidor " + nombreRepartidor);
    }

    @Override
    public void mostrarResumen(){
        System.out.println("ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: " + getTipoDePedido()
                + " | Encomienda: " + encomienda + " | Altura: " + alturaCentimetros + " cm | Ancho: " + anchoCentimetros
                + " cm | Largo: " + largoCentimetros + " cm | Distancia: " + getDistanciaKm() + " KM.");
    }

    @Override
    public void calcularTiempoEntrega(){
        double tiempoEntrega = 20 + (1.5 * getDistanciaKm());
        int tiempoFinal = (int) Math.round(tiempoEntrega);

        if (tiempoEntrega > 60){
            int horas = 1;
            tiempoFinal = tiempoFinal - 60;

            System.out.println("El tiempo de entrega del pedido es de: " + horas + " hora y " + tiempoFinal + " minutos.");
        }else{
            System.out.println("El tiempo de entrega del pedido es de: " + tiempoFinal + " minutos.");
        }
    }

    @Override
    public String toString(){
        return "ID Pedido: " + getIdPedido() + " | Direccion de entrega: " + getDireccionEntrega() + " | Tipo de pedido: " + getTipoDePedido()
                + " | Encomienda: " + encomienda + " | Altura: " + alturaCentimetros + " cm | Ancho: " + anchoCentimetros
                + " cm | Largo: " + largoCentimetros + " cm.";
    }
}
