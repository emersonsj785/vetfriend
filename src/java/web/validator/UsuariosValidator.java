package web.validator;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuariosValidator {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    DaoUsuarios daoUsuarios;

    public UsuariosValidator(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response=response;
        this.daoUsuarios = new DaoUsuariosImpl();
    }

    public String usuariosSel() {
        String result = null;
        List<Usuarios> list = daoUsuarios.usuariosSel();
        if (list != null) {
            request.setAttribute("cartera", list);
        } else {
            result = daoUsuarios.getMensaje();
        }
        return result;
    }

    public String usuariosInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id = (request.getParameter("txtid") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtId"));
        String correo = request.getParameter("txtCorreo");
        String contraseña = request.getParameter("txtContraseña");
        String tipo = request.getParameter("txtTipo");

        if (upd && id == null) {
            result.append("<li>Nro requerido</li>");
        }
        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Dni requerido</li>");
        }
        if (contraseña == null || contraseña.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        }
        if (tipo == null || tipo.trim().length() == 0) {
            result.append("<li>Mensaje requerido</li>");
        }

        Usuarios usuarios = new Usuarios();
        usuarios.setId(id);
        usuarios.setCorreo(correo);
        usuarios.setContraseña(contraseña);
        usuarios.setTipo(tipo);

        if (result.length() == 3) {
            String msg = upd
                    ? daoUsuarios.usuariosUpd(usuarios)
                    : daoUsuarios.usuariosIns(usuarios);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 3) {
            request.setAttribute("usuarios", usuarios);
        }
        return result.length() == 3 ? null : result.append("</ul>").toString();
    }

    public String usuariosGet() {
        String result = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        Usuarios usuarios = daoUsuarios.usuariosGet(id);
        if (usuarios != null) {
            request.setAttribute("usuarios", usuarios);
        } else {
            result = daoUsuarios.getMensaje();
        }
        return result;
    }
    
    public String usuariosDel() {
        List<Integer> nros = new ArrayList<>();
        String _nros = request.getParameter("nros");
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
                ? daoUsuarios.usuariosDel(nros)
                : "Nros incorrectos";
        return result;
    }
    
}
