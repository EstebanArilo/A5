package builder;

public class DemoBuilder {

    // Cualquier método que trabaje con Estudiante debe poder recibir
    // también un EstudianteVirtual sin romperse (LSP)
    static void imprimirPerfil(Estudiante estudiante) {
        System.out.println("Perfil: " + estudiante);
    }

    public static void main(String[] args) {
        // Estudiante presencial: solo obligatorios
        Estudiante presencial = new EstudianteBuilder("Ana Torres", "ana@uniquindio.edu.co")
                .build();

        // Estudiante presencial con opcionales
        Estudiante presencialCompleto = new EstudianteBuilder("Luis Pérez", "luis@uniquindio.edu.co")
                .telefono("3001234567")
                .direccion("Cra 15 #20-30, Armenia")
                .intereses("Robótica, IA")
                .build();

        // Estudiante virtual (subclase), usando su propio builder
        EstudianteVirtual virtual = new EstudianteVirtual.EstudianteVirtualBuilder("Marta Ríos", "marta@uniquindio.edu.co")
                .telefono("3109876543")
                .plataforma("Moodle")
                .build();

        imprimirPerfil(presencial);
        imprimirPerfil(presencialCompleto);
        imprimirPerfil(virtual); // Funciona igual: EstudianteVirtual ES-UN Estudiante (LSP)
    }
}
