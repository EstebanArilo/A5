package singleton;

public class DemoSingleton {
    public static void main(String[] args) {
        // "Jugador 1" solicita la configuración
        ConfiguracionJuego jugador1 = ConfiguracionJuego.getInstancia();
        jugador1.setIdioma("Inglés");
        jugador1.setDificultad("Difícil");
        jugador1.desactivarSonido();

        // "Jugador 2" solicita la configuración en otro punto del programa
        ConfiguracionJuego jugador2 = ConfiguracionJuego.getInstancia();

        System.out.println("¿Es la misma instancia? " + (jugador1 == jugador2));
        System.out.println("Config vista por jugador2: " + jugador2);

        // Nueva configuración agregada sin modificar la clase (OCP)
        jugador2.agregarConfiguracionExtra("resolucion", "1920x1080");
        System.out.println("Resolución: " + jugador1.getConfiguracionExtra("resolucion"));
    }
}
