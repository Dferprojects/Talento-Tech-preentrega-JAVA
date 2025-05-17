package Business;

/*Selecciona “5” para Crear Pedido. El sistema pregunta cuántos productos va a agregar, pide ID de producto y cantidad.
Verifica stock; si no hay suficiente, lanza StockInsuficienteException o un mensaje apropiado.
Si se confirma, descuenta stock y crea el pedido en la colección de pedidos.
* */
public class Pedido {
    private int cantidadArticulos;
    private long idProducto;
    private long cantidadPedidos;
}
