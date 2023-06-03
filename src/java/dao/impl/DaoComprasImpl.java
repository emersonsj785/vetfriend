
package dao.impl;

import dao.DaoCompras;
import dto.Carrito;
import dto.Compra;
import dto.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;;

public class DaoComprasImpl implements DaoCompras{
    
    private ConectaBD conectaDb;
    private String mensaje;
    int r;
    
    public DaoComprasImpl() {
        this.conectaDb = new ConectaBD();

    }

    @Override
    public String ID_Compra() {
        String idCompras = null;
        String sql="select max(ID_Compra) from compras";
        try(Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idCompras=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idCompras;
    }

    @Override
    public int guardarCompra(Compra co) {
        int ID_Compra;
        String sql="insert into compras(ID_Cliente,ID_Pago,FechaCompra,Monto,Estado)values(?,?,?,?,?)";
        try (Connection cn = conectaDb.getConnection()){
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, co.getID_Cliente());
            ps.setInt(2, co.getID_Pago());
            ps.setString(3, co.getFecha());
            ps.setDouble(4, co.getMonto());
            ps.setString(5, co.getEstado());
            ps.executeUpdate();
            
            sql="select @@IDENTITY AS ID_Compra";
            ResultSet rs=ps.executeQuery(sql);
            rs.next();
            ID_Compra=rs.getInt("ID_Compra");
            rs.close();
            
            for (Carrito detalle : co.getDetalleCompras()) {
                sql="insert into detallecompras (ID_Producto, ID_Compra, Cantidad, PrecioCompra	) values (?,?,?,?) ";
                ps=cn.prepareStatement(sql);
                ps.setInt(1, detalle.getCod());
                ps.setInt(2, ID_Compra);
                ps.setInt(3, detalle.getCan());
                ps.setDouble(4, detalle.getPre());
                ps.executeUpdate();
            }
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public List<Compra> comprasSel() {
        List<Compra> comprasg = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("c.ID_Compra, ")
                .append("c.ID_Cliente, ")
                .append("c.ID_Pago, ")
                .append("u.Nombre, ")
                .append("u.Apellido, ")
                .append("c.FechaCompra, ")
                .append("c.Monto, ")
                .append("c.Estado ")
                .append("FROM compras c inner join usuarios u on c.ID_Cliente=u.ID_Cliente");
        try ( Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            comprasg = new ArrayList<>();

            while (rs.next()) {
                Compra compras = new Compra();
                compras.setID_Compra(rs.getInt(1));
                compras.setID_Cliente(rs.getInt(2));
                compras.setID_Pago(rs.getInt(3));
                compras.setNombre(rs.getString(4));
                compras.setApellido(rs.getString(5));
                compras.setFecha(rs.getString(6));
                compras.setMonto(rs.getDouble(7));
                compras.setEstado(rs.getString(8));
                comprasg.add(compras);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return comprasg;
    }

    @Override
    public String getMensaje() {
        String mensaje = "ERROR EN LA CONSULTA";
        return mensaje;
    }

    @Override
    public String comprasDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM compras WHERE ")
                .append("ID_Compra = ? ");
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
    public List<Compra> compraSel(int ID_Cliente) {
        List<Compra> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ID_Compra, ")
                .append("ID_Cliente, ")
                .append("ID_Pago, ")
                .append("FechaCompra, ")
                .append("Monto, ")
                .append("Estado")
                .append(" FROM compras where ID_Cliente=?");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, ID_Cliente);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setID_Compra(rs.getInt(1));
                compra.setID_Cliente(rs.getInt(2));
                compra.setID_Pago(rs.getInt(3));
                compra.setFecha(rs.getString(4));
                compra.setMonto(rs.getDouble(5));
                compra.setEstado(rs.getString(6));
                list.add(compra);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

}
