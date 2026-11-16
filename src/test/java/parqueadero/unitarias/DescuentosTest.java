
package parqueadero.unitarias;

import org.junit.jupiter.api.Test;
import parqueadero.Descuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescuentosTest {

    @Test
    void aplicaDescuentoAClienteFrecuente() {
        Descuentos descuentos = new Descuentos();

        int resultado = descuentos.aplicarDescuento(3000, "frecuente");

        assertEquals(2700, resultado);
    }

    @Test
    void aplicaDescuentoAClienteConConvenio() {
        Descuentos descuentos = new Descuentos();

        int resultado = descuentos.aplicarDescuento(25000, "convenio");

        assertEquals(20000, resultado);
    }

}
