package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.ConectaBD;
import dto.Servicios;
import dto.Carrito;
import web.validator.ServiciosValidator;

@WebServlet(name = "ServiciosServlet", urlPatterns = {"/Servicios"})
public class ServiciosServlet extends HttpServlet {

    ConectaBD cn = new ConectaBD();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "serviciosSel.jsp";
        ServiciosValidator validator = new ServiciosValidator(request, response);

        switch (accion) {
            case "SEL":
                result = validator.serviciosSel();
                target="IntranetAdmin.jsp";
                break;
            case "INS":
                result = validator.serviciosInsUpd(false);
                target = result == null ? "servicios.jsp" : "serviciosIns.jsp";
                break;
            case "DEL":
                result = validator.serviciosDel();
                target = "servicios.jsp";
                break;
            case "GET":
                result = validator.serviciosGet();
                target = "serviciosUpd.jsp";
                break;
            case "GET2":
                result = validator.serviciosGet();
                target = "estadoUpd.jsp";
                break;    
            case "UPD":
                result = validator.serviciosInsUpd(true);
                target = result == null ? "servicios.jsp" : "serviciosUpd.jsp";
                break;
            case "CTL":
                result = validator.serviciosCatal();
                target="catalogoSel.jsp";
                break;
            case "BSQ":
                result = validator.serviciosBuscar();
                target="catalogoSel.jsp";
                break;
            case "EUPD":
                result = validator.estadoUpd(true);
                target = result == null ? "servicios.jsp" : "estadoUpd.jsp";
                break;
                
        }
        if (result != null) {
            request.setAttribute("mensaje", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
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
