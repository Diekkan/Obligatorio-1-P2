package obligatorio1;

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

    public void refrescarEstado(){
        // indicamos donde se encuentra cada auto en la matriz.
        short[][] matrizAEditar = this.getMatriz();

        for(AutitoChocador autito: this.getAutitos()){
            System.out.println(autito.getFila());
            System.out.println(autito.getColumna());

            matrizAEditar[autito.getFila()][autito.getColumna()] = autito.getId();
        }
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        short fila = 0;

        for(short i = 1; i <= dimensiones; i++) {
            if(i == 1){
                // indicador de número de columna
                for(short nColumna = 1; nColumna <= dimensiones; nColumna++){
                    if(nColumna == 1){
                        tablero.append(" ").append(nColumna).append("    ");

                    } else {
                        tablero.append(nColumna).append("    ");
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
            for (short columnas = 1; columnas <= this.getDimensiones() + 1; columnas++) {
                // la primera fila imprime su respectiva letra:
                if (imprimiendoFila == 1 && columnas == 1 && imprimiendoFila != this.getDimensiones()) {
                    // si la matriz tiene un autito en la posición que se está imprimiendo
                    if(this.getMatriz()[fila][columnas] != 0){
                        // chequeamos la dirección de dicho autito
                        short autitoId = this.getMatriz()[fila][columnas];
                        short direccion = hallarDireccion(autitoId);
                        tablero.append((char)('A' + fila - 1)).append("| **");
                    } else {
                        tablero.append((char)('A' + fila )).append("|   ");
                    }
                } else {
                    if(imprimiendoFila == 1 && columnas == 1 && imprimiendoFila != this.getDimensiones()){
                        tablero.append((char)('A' + fila - 1)).append("|   ");
                    } else{
                        tablero.append(" |   ");
                    }
                }
                if (imprimiendoFila == dimensiones) {
                    tablero.append("|");
                }
            }
            tablero.append("\n");
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
