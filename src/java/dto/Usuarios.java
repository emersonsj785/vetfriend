/*
CREATE TABLE `vetfriend`.`usuarios` ( 
`id` INT NOT NULL AUTO_INCREMENT , 
`correo` VARCHAR(100) UNIQUE NOT NULL , 
`clave` BLOB NOT NULL , 
`tipo` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 
 */
package dto;

public class Usuarios {
    private Integer id;
    private String correo;
    private String contraseña;
    private String tipo;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;

    public Usuarios() {
    }

    public Usuarios(Integer id, String correo, String contraseña, String tipo, String nombre, String apellido, String dni, String direccion) {
        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

}
