
package parqueadero.bdd;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import parqueadero.CalculadoraTarifas;
import parqueadero.Descuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarifasSteps {

    private String tipoVehiculo;
    private int minutos;
    private int tarifaCalculada;

    private String tipoCliente;
    private int valorOriginal;
    private int valorConDescuento;

    @Dado("que un vehículo de tipo {string} permanece {int} minutos")
    public void registrarEstadia(String tipo, int duracion) {
        tipoVehiculo = tipo;
        minutos = duracion;
    }

    @Cuando("calculo la tarifa")
    public void calcularTarifa() {
        CalculadoraTarifas calculadora = new CalculadoraTarifas();
        tarifaCalculada = calculadora.calcularTarifa(minutos, tipoVehiculo);
    }

    @Entonces("el valor a pagar es {int} pesos")
    public void verificarTarifa(int esperado) {
        assertEquals(esperado, tarifaCalculada);
    }

    @Dado("que un cliente de tipo {string} tiene un valor de {int} pesos")
    public void registrarCliente(String cliente, int valor) {
        tipoCliente = cliente;
        valorOriginal = valor;
    }

    @Cuando("aplico el descuento")
    public void aplicarDescuento() {
        Descuentos descuentos = new Descuentos();
        valorConDescuento = descuentos.aplicarDescuento(valorOriginal, tipoCliente);
    }

    @Entonces("el valor con descuento es {int} pesos")
    public void verificarDescuento(int esperado) {
        assertEquals(esperado, valorConDescuento);
    }
}


