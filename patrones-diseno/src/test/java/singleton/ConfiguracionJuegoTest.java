package singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfiguracionJuegoTest {

    @Test
    void testInstanciaUnicaParaDiferentesJugadores() {
        ConfiguracionJuego jugador1 = ConfiguracionJuego.getInstancia();
        ConfiguracionJuego jugador2 = ConfiguracionJuego.getInstancia();
        assertTrue(jugador1 == jugador2);
    }

    @Test
    void testConsultarYModificarIdioma() {
        ConfiguracionJuego config = ConfiguracionJuego.getInstancia();
        config.setIdioma("Francés");
        assertTrue(config.getIdioma().equals("Francés"));
    }

    @Test
    void testConsultarYModificarDificultad() {
        ConfiguracionJuego config = ConfiguracionJuego.getInstancia();
        config.setDificultad("Experto");
        assertTrue(config.getDificultad().equals("Experto"));
    }

    @Test
    void testActivarYDesactivarSonido() {
        ConfiguracionJuego config = ConfiguracionJuego.getInstancia();
        config.desactivarSonido();
        assertTrue(!config.isSonidoActivado());
        config.activarSonido();
        assertTrue(config.isSonidoActivado());
    }

    @Test
    void testAgregarConfiguracionExtraSinModificarClase() {
        ConfiguracionJuego config = ConfiguracionJuego.getInstancia();
        config.agregarConfiguracionExtra("brillo", "80%");
        assertTrue(config.getConfiguracionExtra("brillo").equals("80%"));
    }
}
