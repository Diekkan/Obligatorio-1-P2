package AutitosChocadores;

/**
 * @author Diego Merentiel (239689) - Cinthya del Río ()
 */

public class Tablero {
    private short tipo;
    private short dimensiones;
    private short[][] disposicion;

    //constructores
    public Tablero(short unasDimensiones){
        dimensiones = unasDimensiones;
    }

    // getters y setters
    public short getTipo() {
        return tipo;
    }
    public void setTipo(short unTipo) {
        this.tipo = unTipo;
    }
    public short getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(short unasDimensiones) {
        this.dimensiones = unasDimensiones;
    }
    public short[][] getDisposicion() {
        return disposicion;
    }
    public void setDisposicion(short[][] unaDisposicion) {
        this.disposicion = unaDisposicion;
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        short separadorHorizontal = 2;

        for(short i = 1; i <= dimensiones; i++) {
            if(i == 1){
                // indicador de número de columna
                for(short nColumna = 1; nColumna <= dimensiones; nColumna++){
                    tablero.append(nColumna).append("    ");
                }
                tablero.append("\n");
            }
            separadorHorizontal(tablero);
            if(i != dimensiones){
                for(short nFila = 1; nFila <= 4; nFila++){
                    for(short columnas = 1; columnas <= dimensiones + 1; columnas++){
                        if(nFila == 1 && columnas == 1 && nFila != dimensiones){
                            tablero.append(i).append("|    ");
                        }else{
                            tablero.append(" |   ");
                        }
                        if(nFila == dimensiones){
                            tablero.append("|");
                        }
                    }
                    tablero.append("\n");
                }
            }
        }
        return tablero.toString();
    }

    private void separadorHorizontal(StringBuilder tablero) {
            for(short h = 1; h <= dimensiones; h++){
                tablero.append("+----");
                if(h == dimensiones){
                    tablero.append("+");
                }
        }
        tablero.append("\n");

    }

}
