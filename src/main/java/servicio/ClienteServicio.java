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

        if (listaClientes.isEmpty()) {
            System.out.println(ColorConsola.TEXTO_ROJO + "LISTA CLIENTES: Aún no hay clientes ingresados");
            System.out.println(" ");
        }
        for (Cliente cliente : listaClientes) {
            System.out.println(ColorConsola.TEXTO_AMARILLO + "******* D a t o s  d e l  C l i e n t e *********");
            System.out.println(ColorConsola.TEXTO_VERDE + "RUN del cliente: " + cliente.getRunCliente());
            System.out.println("Nombre del cliente: " + cliente.getNombreCliente());
            System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
            System.out.println("Años como cliente: " + cliente.getAnioCliente());
            System.out.println("Estado del cliente: " + cliente.getCategoria());
            System.out.println(" ");
        }
    }

    public void agregarCliente(Cliente cliente) {

        listaClientes.add(cliente);
        System.out.println(ColorConsola.TEXTO_VERDE + "Cliente agregado exitosamente");
        System.out.println(" ");
    }

    public void editarCliente(Cliente clienteEditado, String rut) {

        for (int i = 0; i < listaClientes.size(); i++) {

        }
        listaClientes.add(clienteEditado);
        System.out.println(ColorConsola.TEXTO_VERDE + "Cliente editado exitosamente");
        System.out.println(" ");
    }

    public Cliente buscarRun(List<Cliente> listaClientes, String run) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(run)) {
                return cliente;
            }
        }
        return null;
    }
}




