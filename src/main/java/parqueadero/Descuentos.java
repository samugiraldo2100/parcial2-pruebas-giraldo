
package parqueadero;

public class Descuentos {

    public int aplicarDescuento(int valor, String tipoCliente) {
        if ("frecuente".equals(tipoCliente)) {
            return (int) Math.floor(valor * 0.9);
        }

        if ("convenio".equals(tipoCliente)) {
            return (int) Math.floor(valor * 0.8);
        }

        return valor;
    }
}

