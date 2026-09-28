package model;

public class Entrega {
    private int idEntrega;
    private int idPedido;
    private int idRepartidor;

    public Entrega(int idPedido, int idRepartidor) {
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
    }

    public Entrega(int idEntrega, int idPedido, int idRepartidor) {
        this.idEntrega = idEntrega;
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
    }

    public int getIdEntrega() {
        return idEntrega;
    }
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }
    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
}