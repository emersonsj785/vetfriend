/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web.servlet;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ercan
 */
@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {
    String result = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "nuevo":
                        presentarformulario(request, response);
                        break;
                    case "registrar":
                        registrarUsuario(request, response);
                        break;
                    case "actualizar":
                        actualizarUsuario(request, response);
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                }
            }
        } catch (Exception e) {
            result = "Error: " + e.getMessage();
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

    private void presentarformulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("intranet.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo cargar la vista");
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuariosImpl daoUsu;
        Usuarios usu = null;
        if (request.getParameter("txtemail") != null
                && request.getParameter("txtcontra") != null
                && request.getParameter("txtnombre") != null
                && request.getParameter("txtapellido") != null
                && request.getParameter("txtdni") != null
                && request.getParameter("txtdireccion") != null) {
            usu = new Usuarios();
            usu.setCorreo(request.getParameter("txtemail"));
            usu.setContraseña(request.getParameter("txtcontra"));
            usu.setNombre(request.getParameter("txtnombre"));
            usu.setApellido(request.getParameter("txtapellido"));
            usu.setDni(request.getParameter("txtdni"));
            usu.setDireccion(request.getParameter("txtdireccion"));
            daoUsu = new DaoUsuariosImpl();
            try {
                daoUsu.usuariosIns(usu);
                response.sendRedirect("login.jsp");
            } catch (Exception e) {
                request.setAttribute("mensaje", "No se pudo conectar" + e.getMessage());
                request.setAttribute("Usuarios", usu);
            }
        }
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuariosImpl daoUsu;
        Usuarios usu = null;
        if (request.getParameter("txtdni") != null
                && request.getParameter("txtnombre") != null
                && request.getParameter("txtapellido") != null
                && request.getParameter("txtdireccion") != null
                && request.getParameter("txtcorreo") != null) {
            usu = new Usuarios();
            usu.setDni(request.getParameter("txtdni"));
            usu.setNombre(request.getParameter("txtnombre"));
            usu.setApellido(request.getParameter("txtapellido"));
            usu.setDireccion(request.getParameter("txtdireccion"));
            usu.setCorreo(request.getParameter("txtcorreo"));
            daoUsu = new DaoUsuariosImpl();
            try {
                daoUsu.usuariosUpd(usu);
                response.sendRedirect("login.jsp");
            } catch (Exception e) {
                request.setAttribute("mensaje", "No se pudo conectar" + e.getMessage());
                request.setAttribute("Usuarios", usu);
            }
        }
    }

    private Usuarios obtenerUsuario(HttpServletRequest request) {
        Usuarios u = new Usuarios();
        u.setNombre(request.getParameter("txtCorreo"));
        u.setContraseña(request.getParameter("txtClave"));
        return u;
    }

}
