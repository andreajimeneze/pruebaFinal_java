package servicios;

import modelos.Cliente;
import utilidades.ColorConsola;
import utilidades.Utilidad;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void listarClientes(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "LISTA CLIENTES: Aún no hay clientes ingresados");
        }
            for (Cliente cliente : listaClientes) {
                System.out.println(ColorConsola.TEXTO_AMARILLO + "******* D a t o s  d e l  C l i e n t e *********");
                System.out.println(ColorConsola.TEXTO_VERDE + "RUN del cliente: " + cliente.getRunCliente());
                System.out.println("Nombre del cliente: " + cliente.getNombreCliente());
                System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
                System.out.println("Años como cliente: " + cliente.getAnioCliente() + " años");
                System.out.println("Estado del cliente: " + cliente.getCategoria());
                System.out.println();
            }
    }
    public void agregarCliente(Cliente cliente) {
        if(cliente != null) {
            listaClientes.add(cliente);
            Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Cliente agregado exitosamente");
        } else {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No se puede agregar cliente sin datos");
        }
    }

    public void editarCliente(Cliente clienteAEditar, String nuevoDato, int opcion) {
       if(nuevoDato != null && !nuevoDato.isEmpty()) {
           if(opcion == 1) {
               clienteAEditar.setRunCliente(nuevoDato);
           } else if (opcion == 2) {
               clienteAEditar.setNombreCliente(nuevoDato);
           } else if (opcion == 3) {
               clienteAEditar.setApellidoCliente(nuevoDato);
           } else if (opcion == 4) {
               clienteAEditar.setAnioCliente(nuevoDato);
           }
           Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Dato modificado correctamente");
       } else {
           Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No puede dejar dato en blanco. Intente editar nuevamente");
       }
    }
    public Cliente buscarClienteRun(List<Cliente> listaClientes, String run) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(run)) {
                return cliente;
            }
        }
        return null;
    }
}




