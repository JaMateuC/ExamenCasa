package Programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {

    private HashMap<String,Producto> productos = new HashMap<>();
    private String usuario;

    public Pedido() {
    }

    public Pedido(String usuario) {
        this.usuario = usuario;
        this.productos = new HashMap<>();
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void addProductoPedido(Producto producto){

        if(this.productos.get(producto.getNombre()) == null){
            this.productos.put(producto.getNombre(), producto);
        }else{
            Producto productoEx = this.productos.get(producto.getNombre());
            productoEx.setNumComprado(producto.getNumComprado() + productoEx.getNumComprado());
            this.productos.put(producto.getNombre(), productoEx);
        }


    }

    public void addListaProductosPedido(List<Producto> listaAnadirProductos){

        for(Producto producto: listaAnadirProductos){

            addProductoPedido(producto);

        }

    }

    @Override
    public String toString(){
        return " Usuario : " + this.usuario;
    }

}
