package builder;

/**
 * Subclase de Estudiante para modalidad virtual.
 * Principio LSP: en cualquier lugar donde el programa espere un Estudiante,
 * debe poder recibir un EstudianteVirtual sin que el comportamiento se rompa
 * (ver metodoQueEsperaEstudiante en DemoBuilder).
 */
public class EstudianteVirtual extends Estudiante {

    private final String plataforma;

    protected EstudianteVirtual(EstudianteVirtualBuilder builder) {
        super(builder);
        this.plataforma = builder.plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return "EstudianteVirtual{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", intereses='" + intereses + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }

    // Builder específico para EstudianteVirtual, extiende EstudianteBuilder
    public static class EstudianteVirtualBuilder extends EstudianteBuilder {

        private String plataforma;

        public EstudianteVirtualBuilder(String nombre, String correo) {
            super(nombre, correo);
        }

        public EstudianteVirtualBuilder plataforma(String plataforma) {
            this.plataforma = plataforma;
            return this;
        }

        // Sobrescribimos telefono/direccion/intereses para mantener el
        // encadenamiento fluido devolviendo el tipo correcto
        @Override
        public EstudianteVirtualBuilder telefono(String telefono) {
            super.telefono(telefono);
            return this;
        }

        @Override
        public EstudianteVirtualBuilder direccion(String direccion) {
            super.direccion(direccion);
            return this;
        }

        @Override
        public EstudianteVirtualBuilder intereses(String intereses) {
            super.intereses(intereses);
            return this;
        }

        @Override
        public EstudianteVirtual build() {
            return new EstudianteVirtual(this);
        }
    }
}
