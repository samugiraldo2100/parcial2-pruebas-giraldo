package parqueadero.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import parqueadero.CalculadoraTarifas;

/** Pruebas unitarias iniciales de calcularTarifa. Están incompletas a propósito. */
class CalculadoraTarifasTest {

    private final CalculadoraTarifas calculadora = new CalculadoraTarifas();

    @Test
    @DisplayName("Un carro con una hora y un minuto paga dos horas")
    void carroConUnaHoraYUnMinutoPagaDosHoras() {
        assertEquals(6000, calculadora.calcularTarifa(61, "carro"));
    }

    @Test
    @DisplayName("Una moto con media hora paga una hora")
    void motoConMediaHoraPagaUnaHora() {
        assertEquals(1500, calculadora.calcularTarifa(30, "moto"));
    }

    @Test
    @DisplayName("Rechaza un tipo de vehículo desconocido")
    void rechazaUnTipoDeVehiculoDesconocido() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTarifa(30, "bicicleta"));

    }

    @ParameterizedTest(name = "Carro con {0} minutos debe pagar {1} pesos")
    @CsvSource({
            "14, 0",
            "15, 0",
            "16, 3000"
    })
    void verificaLimiteDeMinutosDeGracia(int minutos, int esperado) {
        assertEquals(esperado, calculadora.calcularTarifa(minutos, "carro"));
    }


    @ParameterizedTest(name = "Carro con {0} minutos debe pagar {1} pesos")
    @CsvSource({
            "59, 3000",
            "60, 3000",
            "120, 6000",
            "121, 9000"
    })
    void verificaCobroPorHoraOFraccion(int minutos, int esperado) {
        assertEquals(esperado, calculadora.calcularTarifa(minutos, "carro"));
    }

    @ParameterizedTest(name = "{0} con {1} minutos debe pagar {2} pesos")
    @CsvSource({
            "carro, 480, 24000",
            "carro, 481, 25000",
            "moto, 420, 10500",
            "moto, 421, 12000",
            "moto, 481, 12000"
    })
    void verificaTopesDiarios(String vehiculo, int minutos, int esperado) {
        assertEquals(esperado, calculadora.calcularTarifa(minutos, vehiculo));
    }

    @ParameterizedTest(name = "{0} con {1} minutos debe pagar {2} pesos")
    @CsvSource({
            "carro, 0, 0",
            "carro, 1440, 25000",
            "moto, 0, 0",
            "moto, 1440, 12000"
    })
    void verificaLimitesValidosDeMinutos(String vehiculo, int minutos, int esperado) {
        assertEquals(esperado, calculadora.calcularTarifa(minutos, vehiculo));
    }

    @ParameterizedTest(name = "Rechaza una estadía de {0} minutos")
    @CsvSource({
            "-1",
            "1441"
    })
    void rechazaMinutosFueraDeRango(int minutos) {
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularTarifa(minutos, "carro")
        );

        assertEquals("Los minutos deben estar entre 0 y 1440", excepcion.getMessage());
    }

    @ParameterizedTest(name = "Rechaza el tipo de vehículo: {0}")
    @ValueSource(strings = {"camion", "CARRO", ""})
    void rechazaTiposDeVehiculoInvalidos(String tipoVehiculo) {
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularTarifa(30, tipoVehiculo)
        );

        assertEquals("Tipo de vehículo no válido", excepcion.getMessage());
    }


}
