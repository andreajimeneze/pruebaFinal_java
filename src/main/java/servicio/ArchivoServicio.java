package servicio;

import lombok.Data;
import modelo.CategoriaEnum;
import modelo.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArchivoServicio extends Exportador {
    ClienteServicio clienteServicio = new ClienteServicio();
    String ruta = "C:/Users/andre/Desktop/";

    public void cargarDatos(String fileName)  {

        String archivo = ruta + fileName;
        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr))  {
            String line;
            while((line = br.readLine()) != null) {
                String[] dato = line.split(",");

                if(dato.length == 5) {

                    Cliente cliente = new Cliente(dato[0], dato[1], dato[2], dato[3], CategoriaEnum.valueOf(dato[4].toUpperCase()));
                    clienteServicio.agregarCliente(cliente);
                }
            }
            System.out.println("Clientes cargados correctamente");
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(clienteServicio.getListaClientes());
    }

    public ClienteServicio getListaServicio() {
        return clienteServicio;
    }
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {

        File archivo = new File(ruta + fileName);

        if(!archivo.exists()) {
            archivo.createNewFile();
            System.out.println("Archivo creado con éxito");
        } else {
            System.out.println("Archivo ya existe");
        }

        try (FileWriter fw = new FileWriter(archivo);
        BufferedWriter bf = new BufferedWriter(fw);) {
            if(archivo.exists()) {
                for(int i = 0; i < listaClientes.size(); i++) {
                    bf.write(listaClientes.get(i).toString());
                    bf.newLine();
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
