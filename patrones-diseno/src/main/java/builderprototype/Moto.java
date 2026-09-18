package builderprototype;

public class Moto extends Vehiculo {

    protected Moto(VehiculoBuilder<?> builder) {
        super(builder);
    }

    protected Moto(Moto original) {
        super(original);
    }

    @Override
    public Vehiculo clonar() {
        return new Moto(this);
    }
}
