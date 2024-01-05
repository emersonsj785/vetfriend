package dao.impl;

import dao.DaoServicios;
import dto.Carrito;
import dto.Servicios;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoServiciosImpl implements DaoServicios, Serializable {

    private ConectaBD conectaDb;
    private String mensaje;

    public DaoServiciosImpl() {
        this.conectaDb = new ConectaBD();

    }

    @Override
    public List<Servicios> serviciosSel() {
        List<Servicios> arreglo = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Servicio,")
                .append("ID_Categoria,")
                .append("Nombre_Servicio,")
                .append("Direccion_Foto,")
                .append("Precio,")
                .append("Descripcion, ")
                .append("estado ")
                .append("FROM servicios");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            arreglo = new ArrayList<>();

            while (rs.next()) {
                Servicios servicios = new Servicios();
                servicios.setIdServicio(rs.getInt(1));
                servicios.setIdcategoria(rs.getInt(2));
                servicios.setNombre(rs.getString(3));
                servicios.setImagen(rs.getString(4));
                servicios.setPrecio(rs.getDouble(5));
                servicios.setDescripcion(rs.getString(6));
                servicios.setEstado(rs.getString(7));
                arreglo.add(servicios);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return arreglo;
    }

    @Override
    public Servicios serviciosGet(Integer ID_Prod) {
        Servicios servicios = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Servicio, ")
                .append("ID_Categoria, ")
                .append("Nombre_Servicio, ")
                .append("Direccion_Foto, ")
                .append("Precio, ")
                .append("Descripcion")
                .append(" FROM servicios")
                .append(" WHERE ID_Servicio = ?");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, ID_Prod);
            ResultSet rs = ps.executeQuery();
            servicios = new Servicios();
            while (rs.next()) {
                servicios.setIdServicio(rs.getInt(1));
                servicios.setIdcategoria(rs.getInt(2));
                servicios.setNombre(rs.getString(3));
                servicios.setImagen(rs.getString(4));
                servicios.setPrecio(rs.getDouble(5));
                servicios.setDescripcion(rs.getString(6));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return servicios;

    }

    @Override
    public String serviciosIns(Servicios servicios) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO servicios( ")
                .append("ID_Categoria, ")
                .append("Nombre_Servicio, ")
                .append("Direccion_Foto, ")
                .append("Precio, ")
                .append("Descripcion, ")
                .append("estado ")
                .append(") VALUES (?,?,?,?,?,'ACTIVO') ");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, servicios.getIdcategoria());
            ps.setString(2, servicios.getNombre());
            ps.setString(3, servicios.getImagen());
            ps.setDouble(4, servicios.getPrecio());
            ps.setString(5, servicios.getDescripcion());
            int pdtos = ps.executeUpdate();
            if (pdtos == 0) {
                mensaje = "cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String serviciosUpd(Servicios servicios) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE servicios SET ")
                .append("ID_Categoria = ?,")
                .append("Nombre_Servicio = ?,")
                .append("Direccion_Foto = ?,")
                .append("Precio = ? , ")
                .append("Descripcion = ? ")
                .append("WHERE ID_Servicio = ? ");

        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, servicios.getIdcategoria());
            ps.setString(2, servicios.getNombre());
            ps.setString(3, servicios.getImagen());
            ps.setDouble(4, servicios.getPrecio());
            ps.setString(5, servicios.getDescripcion());
            ps.setInt(6, servicios.getIdServicio());
            int pdtos = ps.executeUpdate();
            if (pdtos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String serviciosDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM servicios WHERE ")
                .append("ID_Servicio = ? ");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(1, ids.get(i));
                int pdtos = ps.executeUpdate();
                if (pdtos == 0) {
                    ok = false;
                    mensaje = "Cero filas actualizadas";
                }
                if (ok) {
                    cn.commit();
                } else {
                    cn.rollback();
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        String mensaje = "ERROR EN LA CONSULTA";
        return mensaje;
    }

    @Override
    public List<Servicios> serviciosCatal() {
        List<Servicios> catalogo = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Servicio,")
                .append("ID_Categoria,")
                .append("Nombre_Servicio,")
                .append("Direccion_Foto,")
                .append("Precio,")
                .append("Descripcion ")
                .append("FROM servicios where estado='ACTIVO'");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            catalogo = new ArrayList<>();
            while (rs.next()) {
                Servicios pro = new Servicios(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDouble(5), rs.getString(6));
                catalogo.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return catalogo;
    }

    @Override
    public Servicios listarId(int id) {
        List<Servicios> carrito=null;
        String sql = "select * from servicios where ID_Servicio="+id;
        Servicios p = new Servicios();
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setIdServicio(rs.getInt(1));
                p.setIdcategoria(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setImagen(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setDescripcion(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return p;
    }

    @Override
    public List<Servicios> Buscar(String nombre) {
        List<Servicios> prodenc = null;
        String sql="select * from servicios where Nombre_Servicio like '%"+nombre+"%'";   
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            prodenc = new ArrayList<>();
            while (rs.next()) {
                Servicios pro = new Servicios(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDouble(5), rs.getString(6));
                prodenc.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return prodenc;
        
    }

    @Override
    public String estadoUpd(Servicios servicios) {
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE servicios SET estado= ? WHERE ID_Servicio=?");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, servicios.getEstado());
            ps.setInt(2, servicios.getIdServicio());
            int pdtos = ps.executeUpdate();
            if (pdtos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println("error: "+e);
        }
        return mensaje;
    }

}
