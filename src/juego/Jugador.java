package juego;

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

    public Jugador(String unNombre, short unaEdad, String unAlias){
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAlias(unAlias);
        this.setPuntaje(0);
        this.setGanadas(0);
        this.setPerdidas(0);
        this.setAbandonadas(0);
    }

    //toString ???
    @Override
    public String toString(){
        return String.format(("%s - %s"), this.getNombre(), this.getAlias());
    }
}
