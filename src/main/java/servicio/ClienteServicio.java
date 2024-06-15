package servicio;

import modelo.Cliente;
import utilidades.ColorConsola;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void listarClientes(List<Cliente> listaClientes) {

        if(listaClientes.isEmpty()) {
            System.out.println(ColorConsola.TEXTO_ROJO + "LISTA CLIENTES: Aún no hay clientes ingresados");
            System.out.println(" ");
        }
            for(Cliente cliente : listaClientes) {
                System.out.println(ColorConsola.TEXTO_VERDE + "********** D A T O S  D E L  C L I E N T E************");
                System.out.println("RUN del cliente: " +cliente.getRunCliente());
                System.out.println("Nombre del cliente: " +  cliente.getNombreCliente());
                System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
                System.out.println("Años como cliente: " + cliente.getAnioCliente());
                System.out.println("Estado del cliente: " + cliente.getCategoria());
                System.out.println(" ");
        }
        System.out.println(getListaClientes());
    }

    public void agregarCliente(Cliente cliente) {

        listaClientes.add(cliente);
        System.out.println("Cliente agregado exitosamente");
    }

    public void editarCliente(Cliente clienteEditado, String rut) {

        for(int i = 0; i < listaClientes.size(); i++) {

        }
        listaClientes.add(clienteEditado);
        System.out.println("Cliente editado exitosamente");
        System.out.println(" ");
    }
}

