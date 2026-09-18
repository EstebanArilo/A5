package prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibroTest {

    @Test
    void testClonarLibro() {
        Libro original = new Libro("1984", "George Orwell");
        Libro clon = original.clone();
        assertTrue(clon.getTitulo().equals(original.getTitulo()));
        assertTrue(clon.getAutor().equals(original.getAutor()));
    }

    @Test
    void testModificarAnotacionesDelClonNoAfectaOriginal() {
        Libro original = new Libro("1984", "George Orwell");
        Libro clon = original.clone();
        clon.agregarAnotacion("Nota importante");
        assertTrue(original.getAnotaciones().isEmpty());
        assertTrue(!clon.getAnotaciones().isEmpty());
    }

    @Test
    void testModificarMarcadoresDelClonNoAfectaOriginal() {
        Libro original = new Libro("1984", "George Orwell");
        original.agregarMarcador("Cap 1");
        Libro clon = original.clone();
        clon.agregarMarcador("Cap 5");
        assertTrue(original.getMarcadores().size() == 1);
        assertTrue(clon.getMarcadores().size() == 2);
    }

    @Test
    void testModificarResumenDelClonNoAfectaOriginal() {
        Libro original = new Libro("1984", "George Orwell");
        original.setResumen("Resumen original");
        Libro clon = original.clone();
        clon.setResumen("Resumen del clon");
        assertTrue(original.getResumen().equals("Resumen original"));
        assertTrue(clon.getResumen().equals("Resumen del clon"));
    }

    @Test
    void testPersonalizadorDependeDeAbstraccion() {
        Libro clon = new Libro("Rayuela", "Julio Cortázar").clone();
        PersonalizadorLibro personalizador = new PersonalizadorAnotaciones("Nota DIP");
        personalizador.personalizar(clon);
        assertTrue(clon.getAnotaciones().contains("Nota DIP"));
    }
}
