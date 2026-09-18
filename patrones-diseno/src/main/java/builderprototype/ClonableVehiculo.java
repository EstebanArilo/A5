package builderprototype;

/**
 * Interfaz independiente para la clonación (Principio ISP).
 * Se separa de la construcción para que una clase no dependa de métodos
 * que no necesita (ej. algo que solo clona no tiene por qué implementar build()).
 */
public interface ClonableVehiculo {
    Vehiculo clonar();
}
