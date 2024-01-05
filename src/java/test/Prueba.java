
package test;

import dao.DaoUsuarios;
import dao.impl.DaoServiciosImpl;
import dao.impl.DaoUsuariosImpl;
import dto.Servicios;
import dto.Usuarios;
import java.sql.SQLException;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {

       DaoUsuariosImpl daoUsuariosImpl = new DaoUsuariosImpl();
        try {
            Usuarios usuario = daoUsuariosImpl.usuarioLogin("admin@gmail.com", "admin");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("DNI: " + usuario.getDni());
            System.out.println("Dirección: " + usuario.getDireccion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
 

//        user.setDni(78945612);
//        user.setNombre("Mike");
//        user.setApellido("Towers");
//        user.setDireccion("Av Ga");
//        user.setCorreo("mike@gmail.com");
//        try {
//            du.usuariosUpd(user);
//            System.out.println("Fila actualizada");
//        } catch (Exception e) {
//            du.getMensaje();
//        }
            
    }
    
}
