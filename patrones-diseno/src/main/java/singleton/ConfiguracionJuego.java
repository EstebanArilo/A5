package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuración global y centralizada del juego.
 * Patrón: SINGLETON -> garantiza una única instancia accesible globalmente.
 * Principio OCP: el mapa "configuracionesExtra" permite agregar nuevas
 * configuraciones (ej. "brillo", "resolucion") sin modificar la clase.
 */
public class ConfiguracionJuego {

    private String idioma;
    private String dificultad;
    private boolean sonidoActivado;

    // Permite extender la configuración sin tocar la estructura principal (OCP)
    private final Map<String, String> configuracionesExtra;

    // Única instancia estática de la clase
    private static ConfiguracionJuego instancia;

    // Constructor privado: nadie fuera de la clase puede instanciarla con "new"
    private ConfiguracionJuego() {
        this.idioma = "Español";
        this.dificultad = "Normal";
        this.sonidoActivado = true;
        this.configuracionesExtra = new HashMap<>();
    }

    // Punto de acceso global a la única instancia (creación perezosa / lazy)
    public static ConfiguracionJuego getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionJuego();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isSonidoActivado() {
        return sonidoActivado;
    }

    public void activarSonido() {
        this.sonidoActivado = true;
    }

    public void desactivarSonido() {
        this.sonidoActivado = false;
    }

    // Agregar/consultar nuevas configuraciones sin modificar la clase (OCP)
    public void agregarConfiguracionExtra(String clave, String valor) {
        configuracionesExtra.put(clave, valor);
    }

    public String getConfiguracionExtra(String clave) {
        return configuracionesExtra.get(clave);
    }

    @Override
    public String toString() {
        return "ConfiguracionJuego{" +
                "idioma='" + idioma + '\'' +
                ", dificultad='" + dificultad + '\'' +
                ", sonidoActivado=" + sonidoActivado +
                ", extra=" + configuracionesExtra +
                '}';
    }
}
