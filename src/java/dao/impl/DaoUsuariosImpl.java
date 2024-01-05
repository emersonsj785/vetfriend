package dao.impl;

import dao.DaoUsuarios;
import dto.Servicios;
import dto.Usuarios;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoUsuariosImpl implements DaoUsuarios, Serializable {

    private ConectaBD conectaDb;
    String mensaje;

    public DaoUsuariosImpl() {
        this.conectaDb = new ConectaBD();
    }

    @Override
    public Usuarios usuarioLogin(String correo, String clave) throws SQLException{
        Usuarios user = new Usuarios();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Cliente,")
                .append("correo,")
                .append("Tipo,")
                .append("Nombre,")
                .append("Apellido, ")
                .append("DNI, ")
                .append("Direccion ")
                .append(" FROM usuarios ")
                .append("WHERE correo=? AND ")
                .append("clave = AES_ENCRYPT(?,?)");        
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, clave);
            ps.setString(3, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setCorreo(rs.getString(2));
                user.setTipo(rs.getString(3));
                user.setNombre(rs.getString(4));
                user.setApellido(rs.getString(5));
                user.setDni(rs.getString(6));
                user.setDireccion(rs.getString(7));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(e);
        }
        return user;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public List<Usuarios> usuariosSel() {
        List<Usuarios> cartera = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Cliente,")
                .append("correo,")
                .append("Nombre,")
                .append("Apellido,")
                .append("DNI,")
                .append("Direccion ")
                .append("FROM usuarios where Tipo='CLIENT'");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            cartera = new ArrayList<>();

            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setId(rs.getInt(1));
                usuarios.setCorreo(rs.getString(2));
                usuarios.setNombre(rs.getString(3));
                usuarios.setApellido(rs.getString(4));
                usuarios.setDni(rs.getString(5));
                usuarios.setDireccion(rs.getString(6));
                cartera.add(usuarios);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cartera;
        
    }

    @Override
    public Usuarios usuariosGet(Integer nro) {
        Usuarios usuario = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ")
            .append("ID_Cliente,")
            .append("correo,")
            .append("Nombre,")
            .append("Apellido,")
            .append("DNI,")
            .append("Direccion ")
            .append("FROM usuarios ")
            .append("WHERE ID_Cliente = ?");

    try (Connection cn = conectaDb.getConnection()) {
        PreparedStatement ps = cn.prepareStatement(sql.toString());
        ps.setInt(1, nro);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            usuario = new Usuarios();
            usuario.setId(rs.getInt("ID_Cliente"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setNombre(rs.getString("Nombre"));
            usuario.setApellido(rs.getString("Apellido"));
            usuario.setDni(rs.getString("DNI"));
            usuario.setDireccion(rs.getString("Direccion"));
        }
    } catch (Exception e) {
        mensaje = e.getMessage();
    }

    return usuario;
    }

    @Override
    public String usuariosIns(Usuarios usuario) {
    StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuarios( ")
                .append("Correo,")
                .append("Clave,")
                .append("Tipo,")
                .append("Nombre,")
                .append("Apellido,")
                .append("DNI,")
                .append("Direccion")
                .append(") VALUES (?,AES_ENCRYPT(?,?),'CLIENT',?,?,?,?) ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getNombre());
            ps.setString(5, usuario.getApellido());
            ps.setString(6, usuario.getDni());
            ps.setString(7, usuario.getDireccion());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
            mensaje = "cero filas insertadas";
            return "Error: no se pudo realizar el registro"; // Indicar que el registro falló
        } else {
            return "Registro exitoso"; // Indicar que el registro fue exitoso
        }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String usuariosUpd(Usuarios usuarios) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE usuarios SET ")
                .append("Nombre = ?,")
                .append("Apellido = ?,")
                .append("Direccion = ?,")
                .append("Correo = ? ")
                .append("WHERE DNI = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setString(3, usuarios.getDireccion());
            ps.setString(4, usuarios.getCorreo());
            ps.setString(5, usuarios.getDni());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

// UPDATE usuarios SET nombre = "Rauw", apellido = "alejandro",direccion = "Av LArco" WHERE dni = "78945612"

    @Override
    public String usuariosDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM usuarios WHERE ID_Cliente = ? ");
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

 

}
