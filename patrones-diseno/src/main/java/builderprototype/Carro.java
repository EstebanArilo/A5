package builderprototype;

public class Carro extends Vehiculo {

    protected Carro(VehiculoBuilder<?> builder) {
        super(builder);
    }

    protected Carro(Carro original) {
        super(original);
    }

    @Override
    public Vehiculo clonar() {
        return new Carro(this);
    }
}
