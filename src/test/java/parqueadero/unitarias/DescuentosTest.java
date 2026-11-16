
package parqueadero.unitarias;

import org.junit.jupiter.api.Test;
import parqueadero.Descuentos;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void rechazaValoresNegativos() {
        Descuentos descuentos = new Descuentos();

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> descuentos.aplicarDescuento(-1000, "frecuente")
        );

        assertEquals("El valor no puede ser negativo", excepcion.getMessage());
    }

}
