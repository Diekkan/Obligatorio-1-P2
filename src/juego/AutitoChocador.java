package juego;

public class AutitoChocador {
    private short id;
    private short direccion;
    private String color;
    private short fila;
    private short columna;

    //metodos de acceso y modificacion
    public short getDireccion() {
        return direccion;
    }
    public void setDireccion(short unaDireccion) {
        this.direccion = unaDireccion;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String unColor)
    {
        this.color = unColor;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getColumna() {
        return columna;
    }

    public void setColumna(short columna) {
        this.columna = columna;
    }

    public short getFila() {
        return fila;
    }

    public void setFila(short fila) {
        this.fila = fila;
    }
    //constructor

    public AutitoChocador(short unId, String unasCoordenadas){
        // le ponemos un identificador para diferenciarlo en la matriz.
        this.setId(unId);
        // ajustamos los valores de las coordenadas dadas para que sean más fáciles de manejar
        String coordenadas = unasCoordenadas.toUpperCase();
        this.setFila((short)(coordenadas.charAt(0) - 'A'));
        this.setColumna((short)(coordenadas.charAt(1) - '0' - 1));
        this.setDireccion((short)(coordenadas.charAt(2) - '0'));
    }


    @Override
    public String toString (){
        return String.format(("Direccion %s - F:%s/C:%s"),
            this.getDireccion(),
            this.getFila(),
            this.getColumna()
        );
    }
}
