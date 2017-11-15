import Programa.*;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class Test {

    ProductManagerImpl pmi;
    Pedido pedido, pedido2;
    Producto producto1, producto, producto3, producto4, producto5;

    @Before
    public void SetUp(){


        pmi.getInstance();
        producto1 = new Producto("Queso", 3.9);
        producto = new Producto("Cola", 7);
        producto3 = new Producto("Agua", 1);
        producto4 = new Producto("Pan", 0.8);
        producto5 = new Producto("CocaCola", 2);
        pmi.getInstance().addProducto(producto1);
        pmi.getInstance().addProducto(producto1);
        pmi.getInstance().addProducto(producto1);
        pmi.getInstance().addProducto(producto);
        pmi.getInstance().addProducto(producto4);
        pmi.getInstance().addProducto(producto3);
        pmi.getInstance().addProducto(producto3);
        pedido = new Pedido("Jose");
        pedido.addProductoPedido(producto1);
        pedido2 = new Pedido("Manolo");
        pedido2.addProductoPedido(producto3);
        pedido2.addProductoPedido(producto5);
        pedido2.addProductoPedido(producto);

    }

    @After
    public void tearDown(){

        //pmi.clearAll();

    }

    @org.junit.Test
    public void testOrdenarProductosPrecio(){

        pmi.getInstance().ordenarProductosPrecio();

    }

    @org.junit.Test
    public void testRealizarPedido(){

        pmi.getInstance().realizarPedido(pedido2);

    }

    @org.junit.Test
    public void testServirPedido(){

        pmi.getInstance().realizarPedido(pedido);
        pmi.getInstance().realizarPedido(pedido);
        pmi.getInstance().realizarPedido(pedido2);
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();

    }

    @org.junit.Test
    public void testListadoPedidos(){

        pmi.getInstance().realizarPedido(pedido);
        pmi.getInstance().realizarPedido(pedido);
        pmi.getInstance().realizarPedido(pedido2);
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();
        pmi.getInstance().servirPedido();
        pmi.getInstance().listadoPedidosUsuario("Manolo");

    }

    @org.junit.Test
    public void testOrdenarProductoNumComrado(){

        pmi.getInstance().ordenarProductoNumComprado();

    }

}
