package builderprototype;

/**
 * Interfaz independiente para la construcción (Principio ISP).
 * Separada de ClonableVehiculo: construcción y clonación son
 * responsabilidades distintas.
 */
public interface Construible<T> {
    T build();
}
