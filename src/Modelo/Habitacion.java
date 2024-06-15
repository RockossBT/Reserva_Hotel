package Modelo;

public class Habitacion {
    private String id_habitacion;
    private String tipo;
    private String comentario;
    private int precio;
    private int nro_habitacion;
    private int piso;
    private String estado;

    public Habitacion() {
    }

    public Habitacion(String id_habitacion, String tipo, String comentario, int precio, int nro_habitacion, int piso, String estado) {
        this.id_habitacion = id_habitacion;
        this.tipo = tipo;
        this.comentario = comentario;
        this.precio = precio;
        this.nro_habitacion = nro_habitacion;
        this.piso = piso;
        this.estado = estado;
    }

    public Habitacion(String tipo, String comentario, int precio, int nro_habitacion, int piso, String estado) {
        this.tipo = tipo;
        this.comentario = comentario;
        this.precio = precio;
        this.nro_habitacion = nro_habitacion;
        this.piso = piso;
        this.estado = estado;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getNro_habitacion() {
        return nro_habitacion;
    }

    public void setNro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
