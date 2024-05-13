package juego;

import java.util.*;

/**
 * @author Diego Merentiel (239689) - Cinthya Del Río (253728)
 */
public class Main {

    private static ArrayList<Jugador> jugadores = new ArrayList<>(); // jugadores para el ranking
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
                    registrarJugador(input);
                    break;
                case "b":
                    System.out.flush();
                    configurarTablero(input, (short)(1));
                    break;
                case "c":
                    System.out.flush();
                    juego(input);
                    break;
                case "d":
                    System.out.flush();
                    ranking();
                    break;
                default:
                    System.out.println("Insertar una opción válida");
            }
            menuPrompt();
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

    public static void registrarJugador(Scanner input) {

        System.out.println("---Crear nuevo jugador---");
        System.out.println("Ingresa el nombre");
        String nombre = "";
        short edad = 0;
        String alias = "";
        try {
            nombre = input.nextLine();
        } catch (InputMismatchException ex) {
            System.out.println("Nombre no válido");
        }
        System.out.println("Ingresar edad");

        try {
            edad = input.nextShort();
        } catch (InputMismatchException ex) {
            System.out.println("Edad debe ser un número");
        }
        input.nextLine();
        System.out.println( "Ingresar un alias único");
        alias = input.nextLine();
        if(validarAlias(alias)){
           jugadores.add(new Jugador(nombre, edad, alias));
           System.out.println( "Jugador creado correctamente!");
        } else {
            System.out.println( "Ya existe un jugador con ese alias.");
        }

    }

    private static boolean validarAlias(String alias){
        for(Jugador jugador: jugadores) {
            if (jugador.getAlias().equals(alias)) {
                return false;
            }
        }
        return true;
    }

    public static void configurarTablero(Scanner input, short tipo) {

        if(tipo == 0){

        }
        else if(tipo == 1){

            System.out.println("---Crear un tablero personalizado---");
            short cantidadAutitos = 0;
            short dimensiones = 0;
            System.out.println("Indicar el lado del tablero:");
            String lado = input.nextLine();
            // asignar lado del tablero

            System.out.println("Dimensiones del tablero?");

            try {
                dimensiones = input.nextShort();
                while (dimensiones < 5 || dimensiones > 7) {
                    System.out.println("Ingresa dimensiones válidas (5, 6, 7)");
                    dimensiones = input.nextShort();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ingresa dimensiones válidas (5, 6, 7)");
            }

            System.out.println("Cantidad de autos a ingresar en este tablero (de 3 a 12):");
            try {
                cantidadAutitos = input.nextShort();
                while (cantidadAutitos < 3 || cantidadAutitos > 12) {
                    System.out.println("Ingresa una cantidad válida (de 3 a 12)");
                    cantidadAutitos = input.nextShort();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ingresar un número");
            }

            ArrayList<AutitoChocador> autitos = new ArrayList<AutitoChocador>();
            System.out.println("Ahora especifica sus coordenadas:");

            try {
                input.nextLine();
                for (short i = 0; i < cantidadAutitos;) {
                    String coordenada = input.nextLine();
                    if (coordenada.length() == 3) {
                        autitos.add(new AutitoChocador((short)(i + 1), coordenada));
                        i++;
                    } else {
                        System.out.println("Coordenadas no validas");
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Coordenadas no validas");
            }

            tableroPersonalizado = new Tablero("", dimensiones, autitos);

            System.out.println(autitos);
            System.out.println(tableroPersonalizado);
            System.out.println(tableroPersonalizado.getAutitos());

        }
        else if(tipo == 2){

            ArrayList<AutitoChocador> autitos = new ArrayList<>();
            short id = 1;

            autitos.add(new AutitoChocador(id++, "A12"));
            autitos.add(new AutitoChocador(id++, "A21"));
            autitos.add(new AutitoChocador(id++, "A42"));
            autitos.add(new AutitoChocador(id++, "A50"));
            autitos.add(new AutitoChocador(id++, "D52"));
            autitos.add(new AutitoChocador(id++, "E10"));
            autitos.add(new AutitoChocador(id++, "E41"));
            autitos.add(new AutitoChocador(id++, "E53"));

            tableroPersonalizado = new Tablero("", (short)(5), autitos);
            System.out.println(tableroPersonalizado);

        }
    }

    public static void juego(Scanner input) {
        ArrayList<Jugador> jugadoresElegidos = new ArrayList<>();

        System.out.println("---Elegir dos jugadores---");
        short jugOpcion = 1;
        for(Jugador jugador: jugadores) {
            System.out.printf("%s. %s%n", jugOpcion, jugador);
            jugOpcion++;
        }
        boolean elegirDosJugadores = false;
        while(!elegirDosJugadores){
            short jugador1 = input.nextShort();
            try{
                System.out.println("Elegir otro jugador diferente:");
                short jugador2 = input.nextShort();
                if(jugador1 != jugador2){
                    jugadoresElegidos.add(jugadores.get(jugador1 - 1));
                    jugadoresElegidos.add(jugadores.get(jugador2 - 1));
                    elegirDosJugadores = true;
                }
            } catch (IndexOutOfBoundsException ex){
                System.out.println("Elegir un jugador acorde");
            }
        }
        System.out.println(jugadoresElegidos);

        System.out.println("---Elegir tablero---");
        System.out.println("1. Al azar");
        System.out.println("2. Tablero propio");
        System.out.println("3. Predefinido");

        short tipoTablero = input.nextShort();

        switch(tipoTablero){
            case 1:
                configurarTablero(input, (short)(0));
            case 2:
                configurarTablero(input, (short)(1));
            case 3:
                configurarTablero(input, (short)(2));
            default:
                System.out.println("Elije una opción correcta");
        }

        boolean juego = true;
        while(juego){
            System.out.flush();
            System.out.println(tableroPersonalizado);
            System.out.println("--Juego--");
            System.out.println("Inserta coordenadas del autito a jugar");
            System.out.println("S. Muestra una lista de los autos que pueden ser seleccionados");
            System.out.println("X. Abandonar partida");
            System.out.println("R. Rota el tablero 90º en sentido horario.");

            String jugada = input.nextLine();

            switch(jugada){
                case "S":
                    System.out.println("Lista:");
                case "X":
                    juego = false;
            }

        }

    }

    private static void promptJuego(){
        System.out.println("");
    }

    public static void ranking() {

    }

    public static void main(String[] args) {
        menu();
    }

}
