package prototype;

/**
 * Módulo de personalización encargado de las anotaciones de un libro clonado.
 */
public class PersonalizadorAnotaciones implements PersonalizadorLibro {

    private final String anotacion;

    public PersonalizadorAnotaciones(String anotacion) {
        this.anotacion = anotacion;
    }

    @Override
    public void personalizar(Libro libro) {
        libro.agregarAnotacion(anotacion);
    }
}
