package builderprototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder genérico para vehículos. tipo y placa son obligatorios
 * (van en el constructor); color, capacidad y accesorios son opcionales.
 * Implementa Construible<Vehiculo> (ISP: solo construye, no clona).
 * El parámetro genérico T permite un encadenamiento fluido incluso
 * si en el futuro se crean builders más específicos que extiendan este.
 */
public class VehiculoBuilder<T extends VehiculoBuilder<T>> implements Construible<Vehiculo> {

    protected final String tipo;
    protected final String placa;
    protected String color;
    protected int capacidad;
    protected final List<String> accesorios = new ArrayList<>();

    public VehiculoBuilder(String tipo, String placa) {
        this.tipo = tipo;
        this.placa = placa;
    }

    @SuppressWarnings("unchecked")
    public T color(String color) {
        this.color = color;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T capacidad(int capacidad) {
        this.capacidad = capacidad;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T accesorio(String accesorio) {
        this.accesorios.add(accesorio);
        return (T) this;
    }

    @Override
    public Vehiculo build() {
        switch (tipo.toLowerCase()) {
            case "carro":
                return new Carro(this);
            case "moto":
                return new Moto(this);
            case "bicicleta":
                return new Bicicleta(this);
            default:
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }
}
