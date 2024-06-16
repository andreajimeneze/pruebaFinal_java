package utilidades;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utilidad {
    public static void mensaje(String mensaje) {
        System.out.println(ColorConsola.TEXTO_DEFAULT + mensaje);
        System.out.println(" ");
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println(" ");
        }
    }

    public static void delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearArchivo(File archivo) throws IOException {
        if(!archivo.exists()) {
            archivo.createNewFile();
            System.out.println(ColorConsola.TEXTO_AMARILLO +"Archivo se creará");
        } else {
            System.out.println(ColorConsola.TEXTO_AMARILLO + "Archivo se actualizará");
        }
    }
}
