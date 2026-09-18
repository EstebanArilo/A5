package builderprototype;

public class Bicicleta extends Vehiculo {

    protected Bicicleta(VehiculoBuilder<?> builder) {
        super(builder);
    }

    protected Bicicleta(Bicicleta original) {
        super(original);
    }

    @Override
    public Vehiculo clonar() {
        return new Bicicleta(this);
    }
}
