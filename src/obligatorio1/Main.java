package obligatorio1;

import java.util.*;

/**
 * @author Diego Merentiel (239689) - Cinthya Del Río (253728)
 */
public class Main {

    private static Tablero tableroPersonalizado;
    private static Tablero tablero;

    public static void menu() {

        menuPrompt();

        Scanner input = new Scanner(System.in);
        String opcion = input.nextLine();

        while (!opcion.equalsIgnoreCase("e")) {
            switch (opcion.toLowerCase()) {
                case "a":
                    System.out.flush();
                    registrarJugador();
                    break;
                case "b":
                    System.out.flush();
                    configurarTablero(input);
                    break;
                case "c":
                    System.out.flush();
                    juego();
                    break;
                case "d":
                    System.out.flush();
                    ranking();
                    break;
                default:
                    System.out.println("Insertar una opción válida");
            }
            opcion = input.nextLine();
            System.out.flush();
        }
    }

    public static void menuPrompt() {
        System.out.println("----Autitos chocadores----");
        System.out.println();
        System.out.println("Selecciona una de las siguientes opciones:");
        System.out.println("a) Registrá un jugador");
        System.out.println("b) Configurar un tablero propio");
        System.out.println("c) Jugar");
        System.out.println("d) Ranking");
        System.out.println("e) Salir");
        System.out.println();
    }

    public static void registrarJugador() {
    }

    public static void configurarTablero(Scanner input) {

        tableroPersonalizado = new Tablero();
        short cantidadAutitos = 0;
        short dimensiones = 0;
        String lado = "";
        ArrayList<AutitoChocador> autitos = new ArrayList<>();

        System.out.println("---Crear un tablero personalizado---");
        System.out.println("Indicar el lado del tablero:");
        lado = input.nextLine();
        System.out.println("Dimensiones del tablero?");

        try {
            dimensiones = input.nextShort();
            while (dimensiones < 5 || dimensiones > 7) {
                System.out.println("Ingresa dimensiones válidas (5,6,7)");
                dimensiones = input.nextShort();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ingresa un número");
        }

        System.out.println("Cantidad de autos a ingresar en este tablero (de 3 a 12):");
        try {
            cantidadAutitos = input.nextShort();
            while (cantidadAutitos < 3 || cantidadAutitos > 12) {
                System.out.println("Ingresa una cantidad válida(3 a 12)");
                cantidadAutitos = input.nextShort();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ingresa un número");
        }

        System.out.println("Ahora especifica sus coordenadas:");

        try {
            input.nextLine();
            for (short i = 0; i < cantidadAutitos;) {
                String coordenada = input.nextLine();
                if(coordenada.length() == 3){
                    AutitoChocador autito = new AutitoChocador();
                    autito.setCoordenadas(coordenada);
                    autitos.add(autito);
                    i++;
                } else {
                    System.out.println("Coordenadas no válidas");
                }
            }
        } catch(InputMismatchException ex){
            System.out.println("Coordenadas no válidas");
        }
        tableroPersonalizado = new Tablero();
        tableroPersonalizado.setDimensiones(dimensiones);
        tableroPersonalizado.setAutitos(autitos);
        System.out.println(tableroPersonalizado);
    }

    public static void juego() {
    }

    public static void ranking() {
    }

    public static void main(String[] args) {
        menu();
    }

}
