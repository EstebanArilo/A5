package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un libro de la biblioteca digital.
 * Implementa clone() haciendo una copia profunda de anotaciones y marcadores,
 * de forma que modificar el clon NUNCA afecte al libro original.
 */
public class Libro implements LibroPrototype {

    private final String titulo;
    private final String autor;
    private List<String> anotaciones;
    private List<String> marcadores;
    private String resumen;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.anotaciones = new ArrayList<>();
        this.marcadores = new ArrayList<>();
        this.resumen = "";
    }

    @Override
    public Libro clone() {
        Libro copia = new Libro(this.titulo, this.autor);
        // Copia profunda: nuevas listas, no las mismas referencias
        copia.anotaciones = new ArrayList<>(this.anotaciones);
        copia.marcadores = new ArrayList<>(this.marcadores);
        copia.resumen = this.resumen;
        return copia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public List<String> getAnotaciones() {
        return anotaciones;
    }

    public List<String> getMarcadores() {
        return marcadores;
    }

    public String getResumen() {
        return resumen;
    }

    public void agregarAnotacion(String anotacion) {
        anotaciones.add(anotacion);
    }

    public void agregarMarcador(String marcador) {
        marcadores.add(marcador);
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anotaciones=" + anotaciones +
                ", marcadores=" + marcadores +
                ", resumen='" + resumen + '\'' +
                '}';
    }
}
