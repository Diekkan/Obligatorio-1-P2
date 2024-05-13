package juego;

import java.util.ArrayList;

/**
 * @author Diego Merentiel (239689) - Cinthya Del Río (253728)
 */

public class Tablero {
    
    private String tipo;
    private short dimensiones;
    private short[][] matriz;
    private ArrayList<AutitoChocador> autitos;
    
    //metodos de acceso y modificacion
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String untipo) {
        this.tipo = untipo;
    }

    public short getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(short unaDimension) {
        this.dimensiones = unaDimension;
    }

    public short[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(short[][] unaMatriz) {
        this.matriz = unaMatriz;
    }

    public ArrayList<AutitoChocador> getAutitos() {
        return autitos;
    }
    public void setAutitos(ArrayList<AutitoChocador> autitos) {
        this.autitos = autitos;
    }
    
    //constructores
    public Tablero(){
        this.setTipo("sin definir");
        this.setDimensiones((short)(0));
        this.setMatriz(new short[0][0]);
    }

    public Tablero(String unTipo, short unaDimension, ArrayList<AutitoChocador>unosAutitos){
        this.setTipo(unTipo);
        this.setDimensiones(unaDimension);
        this.setAutitos(unosAutitos);
        this.setMatriz(new short[unaDimension][unaDimension]);
        this.refrescarEstado();
        this.imprimirMatriz(this.getMatriz());
    }

    public void imprimirMatriz(short[][] matriz) {
        // Itera a través de cada fila
        for (int i = 0; i < matriz.length; i++) {
            // Itera a través de cada columna en la fila actual
            for (int j = 0; j < matriz[i].length; j++) {
                // Imprime el elemento en la posición actual
                System.out.print(matriz[i][j] + " ");
            }
            // Imprime un salto de línea después de cada fila
            System.out.println();
        }
    }

    //métodos

    public void chequearJugadas(){
        short[][] matriz = this.getMatriz();

        for (short i = 0; i < matriz.length; i++) {
            for(short j = 0; j < matriz.length; j++){
                if(matriz[i][j] != 0){

                }
            }
        }
    }

    public void refrescarEstado(){
        // indicamos donde se encuentra cada auto en la matriz.
        short[][] matrizAEditar = this.getMatriz();

        for(AutitoChocador autito: this.getAutitos()){
            matrizAEditar[autito.getFila()][autito.getColumna()] = autito.getId();
        }

        this.setMatriz(matrizAEditar);
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        short fila = 0;

        for(short i = 0; i < dimensiones; i++) {
            if(i == 0){
                // indicador de número de columna
                for(short nColumna = 0; nColumna < dimensiones; nColumna++){
                    if(nColumna == 0){
                        tablero.append(" ").append(nColumna + 1).append("    ");
                    } else {
                        tablero.append(nColumna + 1).append("    ");
                    }
                }
                tablero.append("\n");
            }
            dibujarSeparadorHorizontal(tablero);
            if(i != dimensiones){
                dibujarCasilleros(tablero, fila);
                fila++;
            }
        }
        dibujarSeparadorHorizontal(tablero);

        return tablero.toString();
    }

    private void dibujarSeparadorHorizontal(StringBuilder tablero) {
            for(short h = 1; h <= dimensiones; h++){
                if(h == 1){
                    tablero.append(" +----");
                } else{
                    tablero.append("+----");
                }
                if(h == dimensiones){
                    tablero.append("+");
                }
        }
        tablero.append("\n");
    }

    private void dibujarCasilleros(StringBuilder tablero, short fila) {

        for(short imprimiendoFila = 1; imprimiendoFila <= 4; imprimiendoFila++) {
            for (short columnas = 0; columnas < this.getDimensiones(); columnas++) {
                // la primera fila imprime su respectiva letra:
                if (imprimiendoFila == 1 && columnas == 0 && imprimiendoFila != this.getDimensiones()) {
                    // si la matriz tiene un autito en la posición que se está imprimiendo
                    tablero.append((char)('A' + fila));
                    System.out.println(this.getMatriz()[fila][columnas]);
                    tablero.append("|");
                    dibujarAutito(tablero, fila, imprimiendoFila, columnas);
                } else {

                    tablero.append(" |");
                    dibujarAutito(tablero, fila, imprimiendoFila, columnas);

                }

            }
            tablero.append(" |\n");
        }
    }

    private void dibujarAutito(StringBuilder tablero, short fila, short imprimiendoFila, short columnas){

        if(this.getMatriz()[fila][columnas] != 0){
            short direccion = hallarDireccion(this.getMatriz()[fila][columnas]);
            if(direccion == 0){
                if(imprimiendoFila == 1){
                    tablero.append(" oo");
                }
                else if(imprimiendoFila != 1){
                    tablero.append(" **");
                }
            }
            else if(direccion == 1){
                if(imprimiendoFila == 2){
                    tablero.append(" **o");
                }
                else if(imprimiendoFila == 3){
                    tablero.append(" **o");
                }
                else{
                    tablero.append("    ");
                }
            }
            else if(direccion == 2){
                if(imprimiendoFila == 4){
                    tablero.append(" oo");
                }
                else if(imprimiendoFila != 4){
                    tablero.append(" **");
                }
            }
            else if(direccion == 3){
                if(imprimiendoFila == 2){
                    tablero.append(" o**");
                }
                else if(imprimiendoFila == 3){
                    tablero.append(" o**");
                }
                else{
                    tablero.append("   ");
                }
            }
        } else {
            tablero.append("   ");
        }
    }

    private short hallarDireccion(short autitoId){
        for(AutitoChocador autito: this.getAutitos()){
            if(autito.getId() == autitoId){
                return autito.getDireccion();
            }
        }
        return -1;
    }

}
