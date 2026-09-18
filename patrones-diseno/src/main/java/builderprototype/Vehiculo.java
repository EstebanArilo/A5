package builderprototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta con los atributos comunes a todo vehículo.
 * Implementa ClonableVehiculo (Prototype) pero NO Construible:
 * la construcción vive en VehiculoBuilder (separación de responsabilidades, ISP).
 */
public abstract class Vehiculo implements ClonableVehiculo {

    protected final String tipo;
    protected final String placa;
    protected final String color;
    protected final int capacidad;
    protected final List<String> accesorios;

    // Constructor usado por el Builder
    protected Vehiculo(VehiculoBuilder<?> builder) {
        this.tipo = builder.tipo;
        this.placa = builder.placa;
        this.color = builder.color;
        this.capacidad = builder.capacidad;
        this.accesorios = new ArrayList<>(builder.accesorios);
    }

    // Constructor de copia, usado al clonar (Prototype)
    protected Vehiculo(Vehiculo original) {
        this.tipo = original.tipo;
        this.placa = original.placa;
        this.color = original.color;
        this.capacidad = original.capacidad;
        this.accesorios = new ArrayList<>(original.accesorios);
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getColor() {
        return color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<String> getAccesorios() {
        return accesorios;
    }

    public void agregarAccesorio(String accesorio) {
        accesorios.add(accesorio);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "placa='" + placa + '\'' +
                ", color='" + color + '\'' +
                ", capacidad=" + capacidad +
                ", accesorios=" + accesorios +
                '}';
    }
}
