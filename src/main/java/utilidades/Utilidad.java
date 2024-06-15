package utilidades;

import modelo.Cliente;

import java.io.IOException;
import java.util.List;

public class Utilidad {
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
}
