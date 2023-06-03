
package dao;
import dto.Servicios;
import java.util.List;
import java.util.ArrayList;


public interface DaoServicios {
    List<Servicios> serviciosSel();
    
    Servicios serviciosGet(Integer id);

    String serviciosIns(Servicios servicio);

    String serviciosUpd(Servicios servicio);

    String serviciosDel(List<Integer> ids);

    List<Servicios> serviciosCatal();
    
    List<Servicios> Buscar(String nombre);

    String getMensaje();
    
    Servicios listarId(int id);
    
    String estadoUpd(Servicios servicio);
}
