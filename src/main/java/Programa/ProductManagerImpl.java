package Programa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
public class ProductManagerImpl implements ProductManager{

    private HashMap<String, Producto> listaProductos;
    private List<Pedido> listaPedidosRealizados;
    private QueueImpl<Pedido> colaPedidos;
    private static ProductManagerImpl productManagerImpl = null;
    private static final Logger logger = LogManager.getLogger(ProductManager.class.getName());

    private ProductManagerImpl() {

        this.listaProductos = new HashMap<>();
        this.listaPedidosRealizados = new ArrayList<Pedido>();
        this.colaPedidos = new QueueImpl<Pedido>(100);

    }

    public static ProductManagerImpl getInstance(){

        if(productManagerImpl == null){

            logger.info("Creating Manger");

            productManagerImpl = new ProductManagerImpl();
        }

        return productManagerImpl;

    }


    public HashMap<String, Producto> ordenarProductosPrecio(){


        List<Producto> listaOrdenada = new ArrayList<Producto>(this.listaProductos.values());

        if(this.listaProductos.isEmpty()){

            this.logger.error("Lista vacia");


            return this.listaProductos;
        }

        this.logger.info("Lista no ordenada");

        for(Producto producto: this.listaProductos.values()){
            this.logger.info(producto);
        }


        Collections.sort(listaOrdenada, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return (int)Math.round(o1.getCoste() - o2.getCoste());
            }
        });

        this.logger.info("Lista ordenada");

        for(Producto producto: listaOrdenada){
            this.logger.info(producto);
        }

        LinkedHashMap<String, Producto> hashOrdenado = new LinkedHashMap<>();

        for(Producto producto: listaOrdenada){
            hashOrdenado.put(producto.getNombre(), producto);
        }

        this.logger.info("Lista ordenada");

        for(Producto producto: hashOrdenado.values()){
            this.logger.info(producto);
        }

        return hashOrdenado;

    }

    public Boolean realizarPedido(Pedido pedido){


        if(this.colaPedidos.size() == this.colaPedidos.getMax()){

            this.logger.error("Numero de pedidos maximo alcanzado");
            return false;
        }

        this.logger.info("Pedidos en cola: " + this.colaPedidos.size());

        this.colaPedidos.push(pedido);

        for(Producto producto : pedido.getProductos().values()){

            addProducto(producto);

        }

        this.logger.info("Pedidos en cola:" + this.colaPedidos.size());


        return true;

    }

    public Boolean servirPedido(){

        if(this.colaPedidos.size() == 0){

            this.logger.error("No hay pedidos");
            return false;
        }

        if(this.listaPedidosRealizados.isEmpty()){

            this.logger.info("No hay pedidos completados aun");

        }else {
            this.logger.info("Pedidos realizados de momento");

            for(Pedido pedido: this.listaPedidosRealizados){

                this.logger.info(pedido);

            }

        }

        this.logger.info("Pedidos en cola: " + colaPedidos.size());

        this.listaPedidosRealizados.add(this.colaPedidos.pop());

        this.logger.info("Pedidos en cola: "  + this.colaPedidos.size());
        this.logger.info("Pedidos realizados actualizada");

        for(Pedido pedido: this.listaPedidosRealizados){

            this.logger.info(pedido);

        }

        return true;

    }

    public List<Pedido> listadoPedidosUsuario(String usuario){

        this.logger.info("Usuario : " + usuario);

        List<Pedido> pedidosUsuario = new ArrayList<Pedido>();

        for (Pedido pedido : this.listaPedidosRealizados){
            if(pedido.getUsuario() == usuario){
                pedidosUsuario.add(pedido);
            }
        }

        if(pedidosUsuario.isEmpty()){
            this.logger.error(usuario + " no tiene pedidos");
        }else {
            this.logger.info("Pedidos : ");
            for(Pedido pedido: pedidosUsuario){
                this.logger.info(pedido);
            }
        }

        return pedidosUsuario;

    }

    public HashMap<String, Producto> ordenarProductoNumComprado(){

        List<Producto> listaOrdenada = new ArrayList<Producto>(this.listaProductos.values());

        if(this.listaProductos.isEmpty()){

            this.logger.error("Lista vacia");


            return this.listaProductos;
        }

        this.logger.info("Lista no ordenada");

        for(Producto producto: this.listaProductos.values()){
            this.logger.info(producto);
        }


        Collections.sort(listaOrdenada, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return o2.getNumComprado() - o1.getNumComprado();
            }
        });

        LinkedHashMap<String, Producto> hashOrdenado = new LinkedHashMap<>();

        for(Producto producto: listaOrdenada){
            hashOrdenado.put(producto.getNombre(), producto);
        }

        this.logger.info("Lista ordenada");

        for(Producto producto: hashOrdenado.values()){
            this.logger.info(producto);
        }

        return hashOrdenado;

    }

    public void clearAll(){

        this.listaProductos.clear();
        this.listaPedidosRealizados.clear();
        while(this.colaPedidos.size() != 0){
            this.colaPedidos.pop();
        }

    }

    public void addProducto(Producto producto){


        if(this.listaProductos.get(producto.getNombre()) == null){
            this.listaProductos.put(producto.getNombre(), producto);

        }else{
            Producto productoEx = this.listaProductos.get(producto.getNombre());
            productoEx.addCompra();
            this.listaProductos.put(producto.getNombre(), productoEx);
        }

        /*for(Producto producto3: this.listaProductos.values()){
            this.logger.info(producto3);
        }*/


    }


}
