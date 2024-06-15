package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    String runCliente;
    String nombreCliente;
    String apellidoCliente;
    String anioCliente;
    CategoriaEnum categoria;
}
