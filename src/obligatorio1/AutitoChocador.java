package obligatorio1;

public class AutitoChocador {
    private String direccion;
    private String color;
    private String coordenadas;
    
    //metodos de acceso y modificacion
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String unaDireccion) {
        this.direccion = unaDireccion;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String unColor) {
        this.color = unColor;
    }

    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String unaCoordenada) {
        this.coordenadas = unaCoordenada;
    }
    //constructor
    
    @Override
    public String toString (){
        return String.format(("Direccion %s, Color %s, Coordenadas %s"),
            this.getDireccion(),
            this.getColor(),
            this.getCoordenadas()
        );
    }
}
