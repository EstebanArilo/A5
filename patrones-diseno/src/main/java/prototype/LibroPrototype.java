package prototype;

/**
 * Abstracción del patrón PROTOTYPE: define el contrato de clonación.
 * Los módulos de personalización dependen de esta interfaz, no de Libro
 * directamente (Principio DIP).
 */
public interface LibroPrototype {
    LibroPrototype clone();
}
