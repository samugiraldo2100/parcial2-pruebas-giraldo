
# language: es

Característica: Cálculo de tarifas y descuentos del parqueadero
  Como dueño del parqueadero EstacionaYa
  Quiero calcular correctamente las tarifas y los descuentos
  Para cobrar a cada cliente el valor correspondiente

  Esquema del escenario: Calcular el valor de una estadía
    Dado que un vehículo de tipo "<tipo>" permanece <minutos> minutos
    Cuando calculo la tarifa
    Entonces el valor a pagar es <total> pesos

    Ejemplos:
      | tipo  | minutos | total |
      | carro | 15      | 0     |
      | carro | 16      | 3000  |
      | carro | 61      | 6000  |
      | carro | 481     | 25000 |
      | moto  | 15      | 0     |
      | moto  | 16      | 1500  |
      | moto  | 61      | 3000  |
      | moto  | 481     | 12000 |

  Escenario: Aplicar descuento a un cliente frecuente
    Dado que un cliente de tipo "frecuente" tiene un valor de 3000 pesos
    Cuando aplico el descuento
    Entonces el valor con descuento es 2700 pesos

  Escenario: Aplicar descuento a un cliente con convenio
    Dado que un cliente de tipo "convenio" tiene un valor de 25000 pesos
    Cuando aplico el descuento
    Entonces el valor con descuento es 20000 pesos
