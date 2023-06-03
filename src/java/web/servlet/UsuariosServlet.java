package web.servlet;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.UsuariosValidator;

@WebServlet(name = "UsuariosServlet", urlPatterns = {"/Usuarios"})
public class UsuariosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;

        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave");
        String result = null;
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        Usuarios u = new Usuarios();
        String target = null;
        String targett = "login.jsp";
        UsuariosValidator validator = new UsuariosValidator(request, response);

        try {
            u = daoUsuarios.usuarioLogin(correo, clave);
            System.out.println(u.getNombre());
            request.setAttribute("user", u);
            if (u != null) {
                final String ID = request.getSession().getId();
                request.getSession().setAttribute("ID", ID);
                request.getSession().setAttribute("usuario", u);
                request.getSession().setAttribute("ID_Cliente", u.getId());
                request.getSession().setAttribute("cliente", u.getNombre());
                request.getSession().setAttribute("dni", u.getDni());
                request.getSession().setAttribute("autorizacion", u.getTipo());
                result += u.getCorreo();
                result += u.getTipo();

                if (u.getTipo().equals("ADMIN")) {
                    target = "Servicios?accion=SEL";
                } else if (u.getTipo().equals("CLIENT")) {
                    target = "actualizar.jsp";
                }

            } else {
                result = "Error al autenticar";
            }
            if (result != null) {
                request.setAttribute("mensaje", result);
            }

            if (target == null) {
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(target);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        switch (accion) {
            case "INS":
                targett = result == null ? "usuarios.jsp" : "registrarse.jsp";
                break;
            default:
                result = "Solicitud no reconocida";
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
