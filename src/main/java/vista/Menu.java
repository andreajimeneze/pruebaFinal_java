package vista;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.ColorConsola;
import utilidades.Utilidad;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    ClienteServicio clienteServicio = new ClienteServicio();
    ArchivoServicio archivoServicio = new ArchivoServicio();
    ExportadorCsv exportarCsv = new ExportadorCsv();
    ExportadorTxt exportarTxt = new ExportadorTxt();
    Scanner sc = new Scanner(System.in);
    String FILE_NAME = "Clientes";
    String FILE_NAME_1 = "DBClientes.csv";

    public void iniciarMenu() throws IOException, InterruptedException {
        int opcion;
        do {
            System.out.println(ColorConsola.TEXTO_MAGENTA + "*********** M E N U **********");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.println(" ");

            System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 1 || opcion > 6)
                System.out.println("Ingrese una opción entre 1 y 6");
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
                archivoServicio.cargarDatos(FILE_NAME_1, clienteServicio.getListaClientes());
                iniciarMenu();
                break;
            case 5:
                archivoServicio.exportar(FILE_NAME, clienteServicio.getListaClientes());
                iniciarMenu();
                break;
            case 6:
                System.out.println("Saliendo del programa ...");
                Utilidad.delay(1400);
                Utilidad.limpiarPantalla();
                System.out.println("Ha salido del programa");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }


    public void agregarCliente() {
        System.out.println("************* Crear Cliente *************");

        System.out.println("Ingresa RUN del Cliente: ");
        String run = sc.nextLine();
        System.out.println("Ingresa Nombre del Cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa Apellido del Cliente: ");
        String apellido = sc.nextLine();
        System.out.println("Ingresa años como Cliente: ");
        String antiguedad = sc.nextLine();

        System.out.println("**********************************************");
        Cliente clienteAgregado = new Cliente(run, nombre, apellido, antiguedad, CategoriaEnum.ACTIVO);

        clienteServicio.agregarCliente(clienteAgregado);
    }

    public void editarCliente() {
        int opcion;
        System.out.println("************* E D I T A R  C L I E N T E *************");

        do {
            System.out.println("Seleccione qué desea hacer: ");
            System.out.println("1.-Cambiar el estado del Cliente ");
            System.out.println("2.-Editar los datos ingresados del Cliente");
            System.out.println(" ");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
        } while (opcion < 1 || opcion > 2);

        System.out.println("Ingresa RUN del Cliente a editar: ");
        String runCliente = sc.nextLine();

        Cliente clienteEncontrado = clienteServicio.buscarRun(clienteServicio.getListaClientes(), runCliente);

        if (clienteEncontrado != null) {
            if (opcion == 1) {
                editarEstado(clienteEncontrado);
            } else if (opcion == 2) {
                editarDatos(clienteEncontrado);
            }
        } else {
            System.out.println("El run no existe");
        }

    }

    public void editarEstado(Cliente clienteEncontrado) {
        System.out.println("------ Actualizando estado del Cliente ------");
        System.out.println("El estado actual del cliente es: " + clienteEncontrado.getCategoria());
        System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
        System.out.println("2.-Si desea mantener el estado del cliente Activo");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            clienteEncontrado.setCategoria(CategoriaEnum.INACTIVO);
        } else if (opcion == 2) {
            clienteEncontrado.setCategoria(CategoriaEnum.ACTIVO);
        }
    }

    public void editarDatos(Cliente clienteEncontrado) {
        int opcion;
        System.out.println("------ Actualizando datos del Cliente ------");
        System.out.println("1.-El RUN del Cliente es: " + clienteEncontrado.getRunCliente());
        System.out.println("2.-El nombre del Cliente es: " + clienteEncontrado.getNombreCliente());
        System.out.println("3.-El apellido del Cliente es: " + clienteEncontrado.getApellidoCliente());
        System.out.println("4.-La antigüedad del Cliente es de: " + clienteEncontrado.getAnioCliente());

        do {
            System.out.println("Ingrese opcion a editar de los datos del cliente: ");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                System.out.println("Ingrese nuevo RUN del Cliente: ");
                String nuevoRun = sc.nextLine();
                clienteEncontrado.setRunCliente(nuevoRun);
                System.out.println("Dato modificado correctamente");
                break;
            case 2:
                System.out.println("Ingrese nuevo nombre del Cliente: ");
                String nuevoNombre = sc.nextLine();
                clienteEncontrado.setNombreCliente(nuevoNombre);
                System.out.println("Dato modificado correctamente");
                break;
            case 3:
                System.out.println("Ingrese nuevo apellido del Cliente: ");
                String nuevoApellido = sc.nextLine();
                clienteEncontrado.setApellidoCliente(nuevoApellido);
                System.out.println("Dato modificado correctamente");
                break;
            case 4:
                System.out.println("Ingrese nueva antigüedad del Cliente: ");
                String nuevoAntiguedad = sc.nextLine();
                clienteEncontrado.setAnioCliente(nuevoAntiguedad);
                System.out.println("Dato modificado correctamente");
                break;
            default:
                System.out.println("opción no válida");
                editarDatos(clienteEncontrado);
        }
    }
}







