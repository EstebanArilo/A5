package builder;

/**
 * Perfil de un estudiante.
 * Patrón: BUILDER -> el objeto solo se construye a través de EstudianteBuilder,
 * evitando un constructor con demasiados parámetros y separando obligatorios
 * (nombre, correo) de opcionales (telefono, direccion, intereses).
 */
public class Estudiante {

    protected final String nombre;
    protected final String correo;
    protected final String telefono;
    protected final String direccion;
    protected final String intereses;

    // Constructor accesible solo desde el paquete: lo usa el Builder (y sus subclases)
    protected Estudiante(EstudianteBuilder builder) {
        this.nombre = builder.nombre;
        this.correo = builder.correo;
        this.telefono = builder.telefono;
        this.direccion = builder.direccion;
        this.intereses = builder.intereses;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getIntereses() {
        return intereses;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", intereses='" + intereses + '\'' +
                '}';
    }
}
