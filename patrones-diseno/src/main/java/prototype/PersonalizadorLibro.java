package prototype;

/**
 * Abstracción para los módulos de personalización (Principio DIP):
 * cualquier personalizador depende de LibroPrototype/Libro a través
 * de esta interfaz, no de una implementación concreta.
 */
public interface PersonalizadorLibro {
    void personalizar(Libro libro);
}
