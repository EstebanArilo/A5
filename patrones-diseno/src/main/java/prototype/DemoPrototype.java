package prototype;

public class DemoPrototype {
    public static void main(String[] args) {
        Libro original = new Libro("Cien años de soledad", "Gabriel García Márquez");
        original.agregarMarcador("Capítulo 1");
        original.setResumen("Resumen general del libro.");

        // Clonamos el libro para personalizarlo sin afectar el original
        Libro clon = original.clone();

        PersonalizadorLibro personalizador = new PersonalizadorAnotaciones("Releer el final");
        personalizador.personalizar(clon);
        clon.agregarMarcador("Capítulo 20");
        clon.setResumen("Resumen personalizado por el lector.");

        System.out.println("Original: " + original);
        System.out.println("Clon:     " + clon);
        System.out.println("¿El original quedó intacto? " + original.getAnotaciones().isEmpty());
    }
}
