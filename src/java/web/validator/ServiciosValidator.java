package web.validator;

import dao.DaoServicios;
import dao.impl.DaoServiciosImpl;
import dto.Servicios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiciosValidator {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final DaoServiciosImpl daoServicio;

    public ServiciosValidator(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.daoServicio = new DaoServiciosImpl();
    }

    public String serviciosSel() {
        String result = null;
        List<Servicios> arreglo = daoServicio.serviciosSel();
        if (arreglo != null) {
            request.setAttribute("arreglo", arreglo);
        } else {
            result = daoServicio.getMensaje();
        }
        return result;
    }

    public String serviciosCatal() {
        String result = null;
        List<Servicios> catalogo = daoServicio.serviciosCatal();
        if (catalogo != null) {
            request.setAttribute("catalogo", catalogo);
        } else {
            result = daoServicio.getMensaje();
        }
        return result;
    }

    public String serviciosInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer ID_Servicio = (request.getParameter("id") == null)
                ? null
                : Integer.valueOf(request.getParameter("id"));
        Integer ID_Categoria = (request.getParameter("categorias") == null)
                ? null
                : Integer.valueOf(request.getParameter("categorias"));

        String nombre = request.getParameter("txtNombre");
        String imagen = request.getParameter("Imagen");

        Double precio = (request.getParameter("txtprecio") == null)
                ? null
                : Double.valueOf(request.getParameter("txtprecio"));
        String descripcion = request.getParameter("txtDescripcion");

        if (upd && ID_Servicio == null) {
            result.append("<li>Id Servicio requerido</li>");
        }
        if (ID_Categoria == null) {
            result.append("<li>Categoria requerida</li>");
        }
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        }
        if (imagen == null || imagen.trim().length() == 0) {
            result.append("<li>Direccion imagen requerido</li>");
        }
        if (precio == null) {
            result.append("<li>Precio requerido</li>");
        }

        Servicios servicio = new Servicios();
        servicio.setIdServicio(ID_Servicio);
        servicio.setIdcategoria(ID_Categoria);;
        servicio.setNombre(nombre);
        servicio.setImagen(imagen);
        servicio.setPrecio(precio);
        servicio.setDescripcion(descripcion);

        if (result.length() == 4) {
            String msg = upd
                    ? daoServicio.serviciosUpd(servicio)
                    : daoServicio.serviciosIns(servicio);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("servicio", servicio);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String serviciosGet() {
        String result = null;
        Integer ID_Servicio = Integer.valueOf(request.getParameter("id"));
        Servicios servicio = daoServicio.serviciosGet(ID_Servicio);
        if (servicio != null) {
            request.setAttribute("servicio", servicio);
        } else {
            result = daoServicio.getMensaje();
        }
        return result;
    }

    public String serviciosDel() {
        List<Integer> nros = new ArrayList<>();
        String _nros = request.getParameter("servicios");
        if (_nros != null) {
            String[] v_nros = _nros.split(",");
            for (String v_nro : v_nros) {
                Integer nro = Integer.valueOf(v_nro);
                if (nro != null) {
                    nros.add(nro);
                } else {
                    nros = null;
                    break;
                }
            }
        }
        String result = (nros != null)
                ? daoServicio.serviciosDel(nros)
                : "Nros incorrectos";
        return result;
    }

    public String serviciosBuscar() {
        String result = null;
        String nombre = request.getParameter("busqueda");
        List<Servicios> prodenc = daoServicio.Buscar(nombre);
        if (prodenc != null) {
            request.setAttribute("prodenc", prodenc);
        } else {
            result = daoServicio.getMensaje();
        }
        return result;
    }
    
    public String estadoUpd(boolean upd) throws IOException, ServletException {
        StringBuilder result = new StringBuilder("<ul>");
        
        Integer ID_Servicio = (request.getParameter("id") == null)
                ? null
                : Integer.valueOf(request.getParameter("id"));
        String estado = request.getParameter("estado");
        
        if (ID_Servicio == null) {
            result.append("<li>Id Servicio requerido</li>");
        }
        
        if (upd & estado == null) {
            result.append("<li>estado requerido</li>");
        }
        Servicios servicio = new Servicios();
        servicio.setEstado(estado);
        servicio.setIdServicio(ID_Servicio);
        
        if (upd) {
            if (result.length() == 4) {
                String msg = daoServicio.estadoUpd(servicio);
                if (msg != null) {
                    result.append("<li>").append(msg).append("</li>");
                }
            }
        } else {
            if (result.length() == 4) {
                String msg = daoServicio.estadoUpd(servicio);
                if (msg != null) {
                    result.append("<li>").append(msg).append("</li>");
                }
            }
        }

        if (result.length() > 4) {
            request.setAttribute("servicio", servicio);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
        
    }
    
}
