
package test;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;

public class Prueba {

    public static void main(String[] args) {
       DaoUsuarios du = new DaoUsuariosImpl();
       
       Usuarios user = new Usuarios();
       
       user.setCorreo("consola2@gmail.com");
       user.setContraseña("consola");
       user.setNombre("consola");
       user.setApellido("Administra");
       user.setDni("78945212");
       user.setDireccion("Av Manrique");
       try{
           System.out.println("Exitoso");
       }catch (Exception e) {
           System.out.println("Error: "+du.getMensaje());
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
