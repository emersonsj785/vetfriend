/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import dto.Compra;
import java.util.List;

/**
 *
 * @author ercan
 */
public interface DaoCompras {
    public String ID_Compra();
    
    public int guardarCompra(Compra co);
    
    List<Compra> comprasSel();
    
    String comprasDel(List<Integer> ids);
    
    String getMensaje();
    
    List<Compra> compraSel(int ID_Cliente);

}
