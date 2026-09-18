package builderprototype;

public class DemoVehiculos {
    public static void main(String[] args) {
        // Construcción con Builder (obligatorios + opcionales)
        Vehiculo carro = new VehiculoBuilder<>("carro", "ABC123")
                .color("Rojo")
                .capacidad(5)
                .accesorio("Aire acondicionado")
                .build();

        Vehiculo moto = new VehiculoBuilder<>("moto", "XYZ987")
                .color("Negro")
                .capacidad(2)
                .build();

        Vehiculo bici = new VehiculoBuilder<>("bicicleta", "BIC001")
                .color("Azul")
                .build();

        System.out.println("Construidos:");
        System.out.println(carro);
        System.out.println(moto);
        System.out.println(bici);

        // Clonación con Prototype + personalización posterior del clon
        Vehiculo carroClonado = carro.clonar();
        carroClonado.agregarAccesorio("Sunroof");

        System.out.println("\nClonado y personalizado:");
        System.out.println("Original: " + carro);
        System.out.println("Clon:     " + carroClonado);
    }
}
