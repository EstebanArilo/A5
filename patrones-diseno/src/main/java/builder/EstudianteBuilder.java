package builder;

/**
 * Builder de Estudiante. nombre y correo son obligatorios (van en el constructor);
 * telefono, direccion e intereses son opcionales y se agregan encadenando métodos.
 */
public class EstudianteBuilder {

    protected final String nombre;
    protected final String correo;
    protected String telefono;
    protected String direccion;
    protected String intereses;

    public EstudianteBuilder(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public EstudianteBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public EstudianteBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public EstudianteBuilder intereses(String intereses) {
        this.intereses = intereses;
        return this;
    }

    public Estudiante build() {
        return new Estudiante(this);
    }
}
