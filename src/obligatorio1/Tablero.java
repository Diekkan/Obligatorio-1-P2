package obligatorio1;

import java.util.*;

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
    public Tablero() {
        this.setTipo("sin definir");
        this.setDimensiones((short) (0));
        this.setMatriz(new short[0][0]);
    }

    public Tablero(short unaDimension, ArrayList<AutitoChocador> unosAutitosChocadores,
            String unTipo) {
        
        String letras = "ABCDEFG";

        this.setAutitos(unosAutitosChocadores);
        this.setDimensiones(unaDimension);
        this.setTipo(unTipo);
        short[][] matriz = new short[unaDimension][unaDimension];
        for (AutitoChocador autito : unosAutitosChocadores) {
            String coordenadas = autito.getCoordenadas();
            short fila = (short)letras.indexOf(coordenadas.charAt(0));
            short columna =(short) coordenadas.charAt(1);
        }
    }

    public Tablero(String unTipo, short unaDimension, short[][] unaMatriz) {
        this.setTipo(unTipo);
        this.setDimensiones(unaDimension);
        this.setMatriz(unaMatriz);
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        short separadorHorizontal = 2;

        for (short i = 1; i <= dimensiones; i++) {
            if (i == 1) {
                // indicador de número de columna
                for (short nColumna = 1; nColumna <= dimensiones; nColumna++) {
                    if (nColumna == 1) {
                        tablero.append(" ").append(nColumna).append("    ");

                    } else {
                        tablero.append(nColumna).append("    ");
                    }
                }
                tablero.append("\n");
            }
            separadorHorizontal(tablero);
            if (i != dimensiones) {
                posicion(tablero, i);
            }
        }
        return tablero.toString();
    }

    private void separadorHorizontal(StringBuilder tablero) {
        for (short h = 1; h <= dimensiones; h++) {
            if (h == 1) {
                tablero.append(" +----");
            } else {
                tablero.append("+----");
            }
            if (h == dimensiones) {
                tablero.append("+");
            }
        }
        tablero.append("\n");
    }

    private void posicion(StringBuilder tablero, short indice) {

        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',};

        for (short nFila = 1; nFila <= 4; nFila++) {
            for (short columnas = 1; columnas <= dimensiones + 1; columnas++) {
                if (nFila == 1 && columnas == 1 && nFila != dimensiones) {
                    if (indice == 5) {
                        tablero.append(letras[indice - 1]).append("| **");
                    } else {
                        tablero.append(letras[indice - 1]).append("|   ");
                    }
                } else {
                    if (indice == 2 && columnas == 5) {
                        tablero.append(letras[indice - 1]).append("| **");
                    } else {
                        tablero.append(" |   ");
                    }
                }
                if (nFila == dimensiones) {
                    tablero.append("|");
                }
            }
            tablero.append("\n");
        }
    }

}
