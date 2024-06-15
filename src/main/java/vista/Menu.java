package vista;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.ColorConsola;
import utilidades.Utilidad;

import java.util.List;
import java.util.Scanner;


public class Menu {
    ClienteServicio clienteServicio = new ClienteServicio();
    ArchivoServicio archivoServicio = new ArchivoServicio();
    ExportadorCsv exportarCsv = new ExportadorCsv();
    ExportadorTxt exportarTxt = new ExportadorTxt();
    Scanner sc = new Scanner(System.in);
    String FILE_NAME = "Clientes";
    String FILE_NAME_1 = "DBClientes.csv";

    public void iniciarMenu() {
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

            if(opcion < 1 || opcion > 6)
                System.out.println("Ingrese una opción entre 1 y 6");
        } while(opcion < 1 || opcion > 6);

        ejecutarMenu(opcion);
    }

    public void ejecutarMenu(int opcion) {
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
                archivoServicio.cargarDatos(FILE_NAME_1);
                iniciarMenu();
                break;
//            case 5:
//                archivoServicio.exportar(String FILE_NAME, List< Cliente > listaClientes);
//                iniciarMenu();
//                break;
//            case 6:
//                System.out.println("Saliendo del programa ...");
//                Utilidad.limpiarPantalla();
//                System.out.println("Ha salido del programa");
//                break;
            default:
                System.out.println("Opción no válida");
        }
    }


    public void agregarCliente() {
        System.out.println("************* Crear Cliente *************");

        System.out.println("Ingresa RUN del Cliente: ");
        String run = sc.nextLine();
        System.out.println("Ingresa Nombre del Cliente: ");
        String nombre =sc.nextLine();
        System.out.println("Ingresa Apellido del Cliente: ");
        String apellido = sc.nextLine();
        System.out.println("Ingresa años como Cliente: ");
        String antiguedad = sc.nextLine();

        System.out.println("**********************************************");
        Cliente clienteAgregado = new Cliente(run, nombre, apellido, antiguedad, CategoriaEnum.ACTIVO);

        clienteServicio.agregarCliente(clienteAgregado);
    }

    public void editarCliente() {
        System.out.println("************* E D I T A R  C L I E N T E *************");
        Cliente cliente = new Cliente();
        String runCliente = cliente.getRunCliente();
        String run;
        int opcion;

        do {
            System.out.println("Seleccione qué desea hacer: ");
            System.out.println("1.-Cambiar el estado del Cliente ");
            System.out.println("2.-Editar los datos ingresados del Cliente");
            System.out.println(" ");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            System.out.println(" ");
        } while(opcion < 1 || opcion > 2);

            System.out.println("Ingresa RUN del Cliente a editar: ");
            run = sc.nextLine();

            if(runCliente.equals(run)) {
                if(opcion == 1) {
                    System.out.println("------ Actualizando estado del Cliente ------");
                    System.out.println("El estado actual del cliente es: " + cliente.getCategoria());
                    System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo ");
                    System.out.println("2.-Si desea mantener el estado del cliente Activo ");
                } else if (opcion == 2) {
                    System.out.println("------ Actualizando datos del Cliente ------");
                    System.out.println("1.-El RUN del Cliente es: 12.123.412-2 ");
                    System.out.println("1.-El RUN del Cliente es: 12.123.412-2 ");
                    System.out.println("1.-El RUN del Cliente es: 12.123.412-2 ");
                    do {
                        System.out.println("Ingrese opcion a editar de los datos del cliente: ");
                        opcion = sc.nextInt();
                    } while(opcion < 1 || opcion > 4);

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese nuevo RUN del Cliente: ");
                            String nuevoRun = sc.nextLine();
                            cliente.setRunCliente(nuevoRun);
                        case 2:
                            System.out.println("Ingrese nuevo nombre del Cliente: ");
                            String nuevoNombre = sc.nextLine();
                            cliente.setRunCliente(nuevoNombre);
                        case 3:
                            System.out.println("Ingrese nuevo apellido del Cliente: ");
                            String nuevoApellido = sc.nextLine();
                            cliente.setRunCliente(nuevoApellido);
                        case 4:
                            System.out.println("Ingrese nueva antigüedad del Cliente: ");
                            String nuevoAntiguedad = sc.nextLine();
                            cliente.setRunCliente(nuevoAntiguedad);
                        default:
                            System.out.println("opción no válida");
                    }

                }
            }



        if(opcion == 1) {
            System.out.println("Cambia el estado");
        } else {
            System.out.println("Edita los datos");
        }
//            System.out.println(" ");
//            System.out.println("Ingresa Nombre del Cliente: ");
//            String nombre = sc.nextLine();
//            System.out.println("Ingresa Apellido del Cliente: ");
//            String apellido = sc.nextLine();
//            System.out.println("Ingresa años como Cliente: ");
//            String antiguedad = sc.nextLine();

    }



}