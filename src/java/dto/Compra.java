
package dto;

import java.util.List;


public class Compra {
    private int ID_Compra;
    private int ID_Cliente;
    private int ID_Pago;
    private String Fecha;
    private double monto;
    private String estado;
    private String Nombre;
    private String Apellido;
    
    private List<Carrito>detalleCompras;

    public Compra() {
    }

    public Compra(int ID_Cliente, int ID_Pago, String Fecha, double monto, 
            String estado, List<Carrito> detalleCompras) {
        this.ID_Cliente = ID_Cliente;
        this.ID_Pago= ID_Pago;
        this.Fecha = Fecha;
        this.monto = monto;
        this.estado = estado;
        this.detalleCompras = detalleCompras;
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Pago() {
        return ID_Pago;
    }

    public void setID_Pago(int ID_Pago) {
        this.ID_Pago = ID_Pago;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carrito> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<Carrito> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
    
}
