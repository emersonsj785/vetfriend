package controller;

import dto.Servicios;
import dao.impl.DaoServiciosImpl;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import org.primefaces.context.RequestContext;
import util.ConectaBD;

@SessionScoped
@Named("controllerManagedBean")
public class ControllerManagedBean implements Serializable {

    private ConectaBD conectaDb;
    private DaoServiciosImpl daoServiciosImpl;
    private List<Servicios> listaServicios;
    private String mensaje;
    private Servicios servicios;
    
    private Servicios servicioSeleccionado;
    private List<Integer> serviciosSeleccionados;
    
    /*Usuario*/
    private Usuarios usuario;
    private DaoUsuariosImpl daoUsuariosImpl;
    
    private String nombreUsuario;
    
     private List<Usuarios> listaUsuarios;
    private Map<Integer, Boolean> usuariosSeleccionados;
    




    public ControllerManagedBean() {
        daoServiciosImpl = new DaoServiciosImpl();
        listaServicios = new ArrayList<>();
        servicios = new Servicios();
        serviciosSeleccionados = new ArrayList<>();
        
        /*Usuario*/
        daoUsuariosImpl = new DaoUsuariosImpl();
        usuario = new Usuarios();
        listaUsuarios = new ArrayList<>();
        usuariosSeleccionados = new HashMap<>();
    }

    public void hola() {
        System.out.println("Hola antes");
        listaServicios = daoServiciosImpl.serviciosSel();
        System.out.println("Hola despues" + listaServicios);
        try {
            //listaServicios = daoServiciosImpl.serviciosSel();
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("index.xhtml");
            System.out.println("Dentro del try" + listaServicios);
        } catch (IOException e) {
            mensaje = daoServiciosImpl.getMensaje();
        }
        System.out.println("Chau");
    }

    public List<Servicios> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public void insertarServicio(Servicios servicios) {
        mensaje = daoServiciosImpl.serviciosIns(servicios);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            hola(); // Actualizar los datos de la lista de servicios
        } catch (IOException e) {
            mensaje = daoServiciosImpl.getMensaje();
        }
    }
    
    /*Actualizat*/
    public void traerServicio(Servicios servicio) throws IOException {
        servicioSeleccionado = daoServiciosImpl.serviciosGet(servicio.getIdServicio());
        FacesContext.getCurrentInstance().getExternalContext().redirect("updateServicio.xhtml");
    }

    public void actualizarServicio() {
        mensaje = daoServiciosImpl.serviciosUpd(servicioSeleccionado);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            hola();
        } catch (IOException e) {
            mensaje = daoServiciosImpl.getMensaje();
        }
    }

    public Servicios getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    public void setServicioSeleccionado(Servicios servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
    }
    
    /*Eliminar*/
    
    
    /*Controller para usuario*/
     public void loginUsuario() throws SQLException {
    Usuarios usuarioEncontrado = daoUsuariosImpl.usuarioLogin(usuario.getCorreo(), usuario.getContraseña());
    if (usuarioEncontrado != null && usuarioEncontrado.getId() != null) {
        // Establecer variable de sesión para el usuario
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioEncontrado);

        // Obtener el nombre del usuario y guardarlo en nombreUsuario
        nombreUsuario = usuarioEncontrado.getNombre(); // Suponiendo que la clase Usuarios tiene un método getNombre() para obtener el nombre del usuario

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            mensaje = "Error al redireccionar a index.xhtml";
        }
    } else {
        // Usuario no encontrado o datos incorrectos
        mensaje = "Usuario y/o contraseña incorrectos";

        // Redireccionar a la misma página utilizando JavaScript
        String redirectScript = "window.location.href = 'login.xhtml';";
        RequestContext.getCurrentInstance().execute(redirectScript);
    }
}
     
     public String getNombreUsuario() {
    return nombreUsuario;
}






      public DaoUsuariosImpl getDaoUsuariosImpl() {
        return daoUsuariosImpl;
    }

    public void setDaoUsuariosImpl(DaoUsuariosImpl daoUsuariosImpl) {
        this.daoUsuariosImpl = daoUsuariosImpl;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
}
    
/*Para traer la lista de usuarios*/
    public List<Usuarios> getListaUsuarios() {
    return daoUsuariosImpl.usuariosSel();
}

    /*Para insertarUsuario*/
    
    public String registrarUsuario() {
    String resultadoRegistro = daoUsuariosImpl.usuariosIns(usuario);

    if (resultadoRegistro.startsWith("Registro")) {
        return "index.xhtml?faces-redirect=true";
    } else {
        // Manejar el error en caso de fallo en el registro
        mensaje = resultadoRegistro;
        return null;
    }
}

/*Actualizar usuario*/
    public void actualizarUsuario() {
    mensaje = daoUsuariosImpl.usuariosUpd(usuarioSeleccionado);

    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("usuarios.xhtml");
    } catch (IOException e) {
        mensaje = daoUsuariosImpl.getMensaje();
    }
}


    /*Traer Usuarios*/
    private Usuarios usuarioSeleccionado;

public void traerUsuario(Usuarios usuario) {
    usuarioSeleccionado = daoUsuariosImpl.usuariosGet(usuario.getId());
    try {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioSeleccionado", usuarioSeleccionado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("usuarioUpdate.xhtml");
    } catch (IOException e) {
        mensaje = daoUsuariosImpl.getMensaje();
    }
}

public Usuarios getUsuarioSeleccionado() {
    return usuarioSeleccionado;
}

public void setUsuarioSeleccionado(Usuarios usuarioSeleccionado) {
    this.usuarioSeleccionado = usuarioSeleccionado;
}

    /*Para eliminar usuarios*/
    public void eliminarUsuarios() {
    List<Usuarios> usuarios = daoUsuariosImpl.usuariosSel();
    List<Integer> usuariosIdsSeleccionados = new ArrayList<>();

    for (Map.Entry<Integer, Boolean> entry : usuariosSeleccionados.entrySet()) {
        if (entry.getValue()) {
            usuariosIdsSeleccionados.add(entry.getKey());
        }
    }

    daoUsuariosImpl.usuariosDel(usuariosIdsSeleccionados);

    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("usuarios.xhtml");
    } catch (IOException e) {
        mensaje = daoUsuariosImpl.getMensaje();
    }
}




    public Map<Integer, Boolean> getUsuariosSeleccionados() {
        return usuariosSeleccionados;
    }

    public void setUsuariosSeleccionados(Map<Integer, Boolean> usuariosSeleccionados) {
        this.usuariosSeleccionados = usuariosSeleccionados;
    }

}
