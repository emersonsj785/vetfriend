package dto;

import java.io.Serializable;

public class Servicios implements Serializable{

    private Integer idServicio;
    private Integer idcategoria;
    private String nombre;
    private String imagen;
    private Double precio;
    private String descripcion;
    private String estado;
    
    
    public Servicios() {
    }

    public Servicios(Integer idServicio, Integer idcategoria, String nombre, String imagen, Double precio, String descripcion) {
        this.idServicio = idServicio;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
