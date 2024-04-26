package obligatorio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Diego Merentiel (239689) - Cinthya Del Río (253728)
 */

public class Main {

    private static Tablero tableroPersonalizado;
    private static Tablero tablero;

    public static void menu(){

        menuPrompt();

        Scanner input = new Scanner(System.in);
        String opcion = input.nextLine();

        while(!opcion.equalsIgnoreCase("e")){
            switch(opcion.toLowerCase()){
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

    public static void menuPrompt(){
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

    public static void registrarJugador(){}

    public static void configurarTablero(Scanner input){

        System.out.println("---Crear un tablero personalizado---");
        System.out.println("Indicar el lado del tablero:");
        String lado = input.nextLine();
        System.out.println("Cantidad de autos a ingresar en este tablero (de 3 a 12):");
        short cantidadAutitos = input.nextShort();
        ArrayList<String> coordenadas = new ArrayList<>();
        System.out.println("Ahora especifica sus coordenadas:");
        for(short i = 0; i < cantidadAutitos;i++){
            coordenadas.add(input.nextLine());
        }
        System.out.println(coordenadas);
        System.out.println("Dimensiones del tablero?");
        short dimensiones = input.nextShort();
        tableroPersonalizado = new Tablero();
        tableroPersonalizado.setDimensiones(dimensiones);
        System.out.println(tableroPersonalizado);
    }

    public static void juego(){}
    public static void ranking(){}

    public static void main(String[] args) {
        menu();
    }


}
