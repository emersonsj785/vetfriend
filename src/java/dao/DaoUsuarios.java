package dao;

import dto.Usuarios;
import java.util.List;
public interface DaoUsuarios {

    Usuarios usuarioLogin(String correo, String clave);
    
    // SELECT (READ)
    List<Usuarios> usuariosSel();

    //SELECT WHERE (READ)
    Usuarios usuariosGet(Integer nro);

    //INSERT (CREATE)
    String usuariosIns(Usuarios usuario);

    //UPDATE (UPDATE)
    String usuariosUpd(Usuarios usuarios);
    
    String getMensaje();
    
    String usuariosDel(List<Integer> ids);
}
