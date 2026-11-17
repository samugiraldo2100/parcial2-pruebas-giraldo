
package parqueadero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes {

    private static final String TOTAL_RECAUDADO = "total_recaudado";

    public Map<String, Integer> resumen(List<Registro> registros) {
        Map<String, Integer> resumenDia = new HashMap<>();

        resumenDia.put("carro", 0);
        resumenDia.put("moto", 0);
        resumenDia.put(TOTAL_RECAUDADO, 0);

        CalculadoraTarifas calculadora = new CalculadoraTarifas();

        for (Registro registro : registros) {
            String tipoVehiculo = registro.tipo();

            resumenDia.put(
                    tipoVehiculo,
                    resumenDia.get(tipoVehiculo) + 1
            );

            int valorEstadia = calculadora.calcularTarifa(
                    registro.minutos(),
                    tipoVehiculo
            );

            resumenDia.put(
                    TOTAL_RECAUDADO,
                    resumenDia.get(TOTAL_RECAUDADO) + valorEstadia
            );
        }

        return resumenDia;
    }
}

