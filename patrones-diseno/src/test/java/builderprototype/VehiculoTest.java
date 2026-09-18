package builderprototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehiculoTest {

    @Test
    void testCrearCarroConDatosObligatorios() {
        Vehiculo carro = new VehiculoBuilder<>("carro", "ABC123").build();
        assertTrue(carro instanceof Carro);
        assertTrue(carro.getPlaca().equals("ABC123"));
    }

    @Test
    void testAgregarCaracteristicasOpcionales() {
        Vehiculo carro = new VehiculoBuilder<>("carro", "ABC123")
                .color("Rojo")
                .capacidad(5)
                .accesorio("GPS")
                .build();
        assertTrue(carro.getColor().equals("Rojo"));
        assertTrue(carro.getCapacidad() == 5);
        assertTrue(carro.getAccesorios().contains("GPS"));
    }

    @Test
    void testCrearMotoYBicicleta() {
        Vehiculo moto = new VehiculoBuilder<>("moto", "XYZ987").build();
        Vehiculo bici = new VehiculoBuilder<>("bicicleta", "BIC001").build();
        assertTrue(moto instanceof Moto);
        assertTrue(bici instanceof Bicicleta);
    }

    @Test
    void testClonarVehiculo() {
        Vehiculo original = new VehiculoBuilder<>("carro", "ABC123").color("Rojo").build();
        Vehiculo clon = original.clonar();
        assertTrue(clon.getPlaca().equals(original.getPlaca()));
        assertTrue(clon != original);
    }

    @Test
    void testPersonalizarClonNoAfectaOriginal() {
        Vehiculo original = new VehiculoBuilder<>("moto", "XYZ987").build();
        Vehiculo clon = original.clonar();
        clon.agregarAccesorio("Alarma");
        assertTrue(original.getAccesorios().isEmpty());
        assertTrue(!clon.getAccesorios().isEmpty());
    }
}
