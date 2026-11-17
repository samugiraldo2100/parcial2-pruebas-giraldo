
package parqueadero;

import java.util.Map;

public class Descuentos {

    private static final Map<String, Integer> PORCENTAJES = Map.of(
            "ninguno", 0,
            "frecuente", 10,
            "convenio", 20
    );

    public int aplicarDescuento(int valor, String tipoCliente) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }

        if (tipoCliente == null || !PORCENTAJES.containsKey(tipoCliente)) {
            throw new IllegalArgumentException("Tipo de cliente no válido");
        }

        int porcentaje = PORCENTAJES.get(tipoCliente);

        return (int) ((long) valor * (100 - porcentaje) / 100);
    }
}

