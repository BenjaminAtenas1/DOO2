package cl.duoc.app;


import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoEncomienda = new PedidoEncomienda(415263, "Pajaritos 2132, maipu",
                "Entrega encomienda", "Ropa", 30,30,40);
        Pedido pedidoComida = new PedidoComida(748596, "Los arboles 6544, pudahuel",
                "Entra de comida", "Hamburguesa", true);
        Pedido pedidoExpress = new PedidoExpress(987654, "Los perros 857485, santiago",
                "Entrega express", "tomates", "Supermercado Lider");

        //Metodo de sobrescritura encomienda
        pedidoEncomienda.asignarRepartidor();
        //Metodo de sobrecarga encomienda
        ((PedidoEncomienda)pedidoEncomienda).asignarRepartidor("Juanito perez", "Camioneta");

        System.out.println("\n");

        //Metodo de sobrescritura pedido comida
        pedidoComida.asignarRepartidor();
        //Metodo de sobrecarga pedido de comida
        ((PedidoComida)pedidoComida).asignarRepartidor("Pedrito", "Mochila termica");

        System.out.println("\n");

        //Metodo de sobrescritura pedido express
        pedidoExpress.asignarRepartidor();
        //MEtodo de sobrecarga pedido express
        ((PedidoExpress)pedidoExpress).asignarRepartidor("John cena", 500);

    }
}