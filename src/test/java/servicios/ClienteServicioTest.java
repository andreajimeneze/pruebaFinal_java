package servicios;

import modelos.CategoriaEnum;
import modelos.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ClienteServicioTest {
    private ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() {
        clienteServicio = new ClienteServicio();
    }

    @Test
    @DisplayName("Test método listarCliente")
    void testListarClientes() {
        Cliente cliente = new Cliente("9.339.873-4", "Andrea", "Jiménez", "4", CategoriaEnum.ACTIVO);
        Cliente cliente1 = new Cliente("9.339.873-k", "Gerardo", "Jiménez", "6", CategoriaEnum.ACTIVO);

        clienteServicio.agregarCliente(cliente);
        clienteServicio.agregarCliente(cliente1);

        List<Cliente> listaClientes = clienteServicio.getListaClientes();
        clienteServicio.listarClientes(listaClientes);
        assertEquals(2, listaClientes.size(), "Deben haber 2 clientes en la lista");
        assertTrue(listaClientes.contains(cliente), "La lista contiene a cliente");
        assertTrue(listaClientes.contains(cliente1), "La lista contiene a cliente1");

    }
    @Test
    @DisplayName("Test método agregarCliente")
    void testAgregarCliente() {
        Cliente cliente = new Cliente("9.339.873-4", "Andrea", "Jiménez", "4", CategoriaEnum.ACTIVO);
        clienteServicio.agregarCliente(cliente);
        assertEquals(cliente, clienteServicio.getListaClientes().get(0));
    }

    @Test
    @DisplayName("Test método agregarCliente null")
    void testAgregarClienteNull() {
        clienteServicio.agregarCliente(null);
        assertTrue(clienteServicio.getListaClientes().isEmpty(), "No es posible agregar cliente null");
    }

    @Test
    @DisplayName("Test método editarCliente")
    void testEditarCliente() {
        Cliente cliente = new Cliente("9.339.873-4", "Andrea", "Jiménez", "4", CategoriaEnum.ACTIVO);
        String nuevoDato = "Cecilia Andrea";
        clienteServicio.editarCliente(cliente, nuevoDato, 2);
        assertEquals(nuevoDato, cliente.getNombreCliente(), "El nuevo dato modifica el elemento 2 del cliente - en este caso nombreCliente");

    }

    @Test
    @DisplayName("Test método editarCliente nulo")
    void testEditarClienteNull() {
        Cliente cliente = new Cliente("9.339.873-4", "Andrea", "Jiménez", "4", CategoriaEnum.ACTIVO);
        String nuevoDato = null;
        clienteServicio.editarCliente(cliente, nuevoDato, 2);
        assertEquals("Andrea", cliente.getNombreCliente(), "Nombre cliente no cambia cuando el nuevoDato es null");
    }

    @Test
    @DisplayName("Test método buscar cliente por RUN: buscarClienteRun")
    void testBuscarClienteRun() {
        Cliente cliente = new Cliente("9.339.873-4", "Andrea", "Jiménez", "4", CategoriaEnum.ACTIVO);
        Cliente cliente1 = new Cliente("9.339.873-k", "Gerardo", "Jiménez", "6", CategoriaEnum.ACTIVO);

        clienteServicio.agregarCliente(cliente);
        clienteServicio.agregarCliente(cliente1);

        List<Cliente> listaClientes = clienteServicio.getListaClientes();

        Cliente clientePorRun = clienteServicio.buscarClienteRun(listaClientes, "9.339.873-4");
        assertEquals(cliente, clientePorRun);
    }
}
