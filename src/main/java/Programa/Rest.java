package Programa;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")

public class Rest {

    private ProductManagerImpl pmi;


    @GET
    @Path("/got/listaOrdenada/precio")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getOrdenarProductosPrecio() {

        List<Producto> products = new ArrayList<>();
        products.addAll(this.pmi.getInstance().ordenarProductosPrecio().values());

        return products;
    }

    @GET
    @Path("/got/listaOrdenada/numVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getOrdenarProductoNumComprado() {

        List<Producto> products = new ArrayList<>();
        products.addAll(this.pmi.getInstance().ordenarProductoNumComprado().values());

        return products;
    }

    @GET
    @Path("/got/pedidos/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> getOrdenarProductoNumComprado(@PathParam("usuario") String usuario) {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.addAll(this.pmi.getInstance().listadoPedidosUsuario(usuario));
        return pedidos;

    }

    @GET
    @Path("/got/pedidos/servir")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getRealizarPedido() {
        if(this.pmi.getInstance().servirPedido()){
            return Response.status(200).entity("Pedido Realizado").build();
        }
        return Response.status(200).entity("Error realizar pedido").build();

    }

    @POST
    @Path("/new/Pedido/{usuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPedido(@PathParam("usuario") String usuario, List<Producto> productos) {

        Pedido pedido = new Pedido(usuario);

        pedido.addListaProductosPedido(productos);
        Boolean res = this.pmi.getInstance().realizarPedido(pedido);
        if(res){
            return Response.status(201).entity("Pedido anadido").build();
        }
        return Response.status(409).entity("Error al anadir pedido").build();

    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLogin() {

        return "true";

    }

}
