package vista;

import modelos.CategoriaEnum;
import modelos.Cliente;
import servicios.ArchivoServicio;
import servicios.ClienteServicio;
import utilidades.ColorConsola;
import utilidades.Utilidad;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    ClienteServicio clienteServicio = new ClienteServicio();
    ArchivoServicio archivoServicio = new ArchivoServicio();
    Scanner sc = new Scanner(System.in);
    String FILE_NAME = "Clientes";
    String FILE_NAME_1 = "DBClientes.csv";

    public void iniciarMenu() throws IOException, InterruptedException {
        int opcion = 0;

        do {
            System.out.println(ColorConsola.TEXTO_MAGENTA + "******* M E N U  P R I N C I P A L *******");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.println();

            try {
                System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor numérico");
                sc.next();
            }
            System.out.println();
        } while (opcion < 1 || opcion > 6);

        ejecutarMenu(opcion);
    }

    public void ejecutarMenu(int opcion) throws IOException, InterruptedException {
        switch (opcion) {
            case 1:
                clienteServicio.listarClientes(clienteServicio.getListaClientes());
                iniciarMenu();
                break;
            case 2:
                agregarCliente();
                iniciarMenu();
                break;
            case 3:
                editarCliente();
                iniciarMenu();
                break;
            case 4:
                archivoServicio.cargarDatos(FILE_NAME_1, clienteServicio.getListaClientes(), sc);
                iniciarMenu();
                break;
            case 5:
                exportarDatos();
                iniciarMenu();
                break;
            case 6:
                System.out.println("Saliendo del programa ...");
                Utilidad.delay(1400);
                Utilidad.limpiarPantalla();
                System.out.println("Ha salido del programa");
                break;
        }
    }

    public void agregarCliente() {
        System.out.println(ColorConsola.TEXTO_CYAN + "************* C r e a r  C l i e n t e *************");

        System.out.println("Ingresa RUN del Cliente: ");
        String run = sc.nextLine();
        Cliente clienteAAgregar = clienteServicio.buscarClienteRun(clienteServicio.getListaClientes(), run);
        if (clienteServicio.getListaClientes().contains(clienteAAgregar)) {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No se puede agregar cliente. Run ya existe");
            agregarCliente();
        } else if (run.isEmpty()) {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No se puede agregar cliente sin RUN");
        } else {
            System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingresa Nombre del Cliente: ");
            String nombre = sc.nextLine();
            System.out.println("Ingresa Apellido del Cliente: ");
            String apellido = sc.nextLine();
            System.out.println("Ingresa años como Cliente: ");
            String antiguedad = sc.nextLine();

            System.out.println();

            if (!nombre.isEmpty() && !apellido.isEmpty()) {
                Cliente clienteAgregado = new Cliente(run, nombre, apellido, antiguedad, CategoriaEnum.ACTIVO);
                clienteServicio.agregarCliente(clienteAgregado);
            } else {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No se puede agregar cliente sin datos");
            }
        }
    }


    public void editarCliente() {
        int opcion = 0;

        do {
            System.out.println(ColorConsola.TEXTO_CYAN + "******** E d i t a r  C l i e n t e ********");
            System.out.println(" ");
            System.out.println("Seleccione qué desea hacer: ");
            System.out.println("1.-Cambiar el estado del Cliente ");
            System.out.println("2.-Editar los datos ingresados del Cliente");
            System.out.println(" ");

            try {
                System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch(Exception e) {
                System.out.println(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor numérico");
                sc.next();
            }
        } while (opcion < 1 || opcion > 2);

        System.out.println("Ingresa RUN del Cliente a editar: ");
        String runCliente = sc.nextLine();
        System.out.println();
        Cliente clienteEncontrado = clienteServicio.buscarClienteRun(clienteServicio.getListaClientes(), runCliente);

        if (clienteEncontrado != null) {
            if (opcion == 1) {
                editarEstado(clienteEncontrado);
            } else if (opcion == 2) {
                editarDatos(clienteEncontrado);
            }
        } else {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "El cliente no existe");
        }
    }

    public void editarEstado(Cliente clienteEncontrado) {
        int opcion = 0;
        do {
            System.out.println(ColorConsola.TEXTO_AMARILLO + "------ Actualizando estado del Cliente ------");
            System.out.println(" ");
            System.out.println(ColorConsola.TEXTO_VERDE +"El estado actual del cliente es: " + clienteEncontrado.getCategoria());
            System.out.println(" ");
            System.out.println(ColorConsola.TEXTO_CYAN + "1.-Si desea cambiar el estado del Cliente a Inactivo");
            System.out.println("2.-Si desea mantener el estado del cliente Activo");
            System.out.println();

            try {
                System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese una opción: ");
                opcion = sc.nextInt();
            } catch(Exception e) {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor numérico");
                sc.next();
            }
        } while(opcion < 1 || opcion > 2);

            if (opcion == 1) {
                clienteEncontrado.setCategoria(CategoriaEnum.INACTIVO);
                Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Dato modificado con éxito");
            } else if (opcion == 2) {
                clienteEncontrado.setCategoria(CategoriaEnum.ACTIVO);
                Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Dato modificado con éxito");
            } else {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor");
            }
    }

    public void editarDatos(Cliente clienteEncontrado) {
        int opcion = 0;
        do {
            System.out.println(ColorConsola.TEXTO_AMARILLO + "------ Actualizando datos del Cliente ------");
            System.out.println();
            System.out.println(ColorConsola.TEXTO_VERDE + "1.-El RUN del Cliente es: " + clienteEncontrado.getRunCliente());
            System.out.println("2.-El nombre del Cliente es: " + clienteEncontrado.getNombreCliente());
            System.out.println("3.-El apellido del Cliente es: " + clienteEncontrado.getApellidoCliente());
            System.out.println("4.-La antigüedad del Cliente es de: " + clienteEncontrado.getAnioCliente() + "años");
            System.out.println();

            try {
                System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese opcion a editar de los datos del cliente: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } catch(Exception e) {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor numérico");
                sc.next();
            }
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                System.out.println("Ingrese nuevo RUN del Cliente: ");
                String nuevoRun = sc.nextLine();
                clienteServicio.editarCliente(clienteEncontrado, nuevoRun, 1);
                break;
            case 2:
                System.out.println("Ingrese nuevo nombre del Cliente: ");
                String nuevoNombre = sc.nextLine();
                clienteServicio.editarCliente(clienteEncontrado, nuevoNombre, 2);
                break;
            case 3:
                System.out.println("Ingrese nuevo apellido del Cliente: ");
                String nuevoApellido = sc.nextLine();
                clienteServicio.editarCliente(clienteEncontrado, nuevoApellido, 3);
                break;
            case 4:
                System.out.println("Ingrese nueva antigüedad del Cliente: ");
                String nuevaAntiguedad = sc.nextLine();
                clienteServicio.editarCliente(clienteEncontrado, nuevaAntiguedad, 4);
                break;
        }
    }

    public void exportarDatos() throws IOException {
        int opcion = 0;
        do {
            System.out.println(ColorConsola.TEXTO_CYAN + "************ E x p o r t a r  D a t o s ************");
            System.out.println("Seleccione el formato a exportar:");
            System.out.println("1.-Formato csv");
            System.out.println("2.-Formato txt");
            System.out.println();

            try {
                System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese una opción para exportar:");
                opcion = sc.nextInt();
                sc.nextLine();
            } catch(Exception e) {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: Debe ingresar un valor numérico");
            }
        } while(opcion < 1 || opcion > 2);

            archivoServicio.exportar(FILE_NAME, clienteServicio.getListaClientes(), opcion);
    }
}




