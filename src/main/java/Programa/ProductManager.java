package Programa;

import java.util.HashMap;
import java.util.List;

public interface ProductManager {

    HashMap<String, Producto> ordenarProductosPrecio();
    Boolean realizarPedido(Pedido pedido);
    Boolean servirPedido();
    List<Pedido> listadoPedidosUsuario(String usuario);
    HashMap<String, Producto> ordenarProductoNumComprado();

}
