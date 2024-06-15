package Modelo;

import java.util.Date;

public class Cliente {
    private String id_cliente;
    private String nombre;
    private Date fecha_nac;
    private String telefono;
    private String correo;
    
    public Cliente() {
    }

    public Cliente(String id_cliente, String nombre, Date fecha_nac, String telefono, String correo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(String nombre, Date fecha_nac, String telefono, String correo) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
