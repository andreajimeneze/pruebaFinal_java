package servicios;

import modelos.CategoriaEnum;
import modelos.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ClienteServicioTest {
    private ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() {
        clienteServicio = new ClienteServicio();
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
        assertTrue(clienteServicio.getListaClientes().isEmpty());
    }
}
