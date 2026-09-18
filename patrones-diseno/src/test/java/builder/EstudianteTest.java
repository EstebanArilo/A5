package builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EstudianteTest {

    @Test
    void testCrearEstudianteConDatosObligatorios() {
        Estudiante estudiante = new EstudianteBuilder("Ana Torres", "ana@uniquindio.edu.co").build();
        assertTrue(estudiante.getNombre().equals("Ana Torres"));
        assertTrue(estudiante.getCorreo().equals("ana@uniquindio.edu.co"));
    }

    @Test
    void testAgregarTelefonoOpcional() {
        Estudiante estudiante = new EstudianteBuilder("Ana", "ana@correo.com")
                .telefono("3001112233")
                .build();
        assertTrue(estudiante.getTelefono().equals("3001112233"));
    }

    @Test
    void testAgregarDireccionYInteresesOpcionales() {
        Estudiante estudiante = new EstudianteBuilder("Ana", "ana@correo.com")
                .direccion("Cra 1 #2-3")
                .intereses("Música")
                .build();
        assertTrue(estudiante.getDireccion().equals("Cra 1 #2-3"));
        assertTrue(estudiante.getIntereses().equals("Música"));
    }

    @Test
    void testConstruirEstudianteVirtual() {
        EstudianteVirtual virtual = new EstudianteVirtual.EstudianteVirtualBuilder("Marta", "marta@correo.com")
                .plataforma("Moodle")
                .build();
        assertTrue(virtual.getPlataforma().equals("Moodle"));
    }

    @Test
    void testEstudianteVirtualSustituyeAEstudiante() {
        // LSP: se asigna a una referencia de tipo Estudiante sin problema
        Estudiante estudiante = new EstudianteVirtual.EstudianteVirtualBuilder("Marta", "marta@correo.com")
                .plataforma("Zoom")
                .build();
        assertTrue(estudiante instanceof Estudiante);
        assertTrue(estudiante.getNombre().equals("Marta"));
    }
}
