package obligatorio1;

public class Jugador {
    //variables de instancia
    private String nombre;//no ranking
    private int edad;//no ranking
    private String alias;
    private int partidas;
    private int ganadas;
    private int perdidas;
    private int abandonadas;
    private int puntaje;
    
    //metodos de acceso y modificacion
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String unAlias) {
        this.alias = unAlias;
    }

    public int getPartidas() {
        return partidas;
    }
    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getGanadas() {
        return ganadas;
    }
    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }
    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getAbandonadas() {
        return abandonadas;
    }
    public void setAbandonadas(int abandonadas) {
        this.abandonadas = abandonadas;
    }

    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    //constructor sin parametros
    
    //constructor con parametros
    
    //toString ???
}
