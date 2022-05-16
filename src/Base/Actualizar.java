/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author JULIO
 */
public class Actualizar {
    
    
    Connection conex;
    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;
    int respuesta;
    String sql;
    
    public Actualizar(){
        conex = c.ConectarBD();
    }
    
    
    public int actualizarProveedor(int id_proveedor,String Nombre, String Telefono, String RFC){
        sql="update Proveedor set nombre='"+Nombre+"', telefono='"+Telefono+"' , rfc='"+RFC+"' where id_proveedor="+id_proveedor+"";
        respuesta=0;
        
        try{
            st=conex.createStatement();
            respuesta=st.executeUpdate(sql);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return respuesta;
    }
    
    public int actualizarCategoria(String nombre_c,String descripcion, int id_categoria ){
        sql="update Categoria set nombre_c='"+nombre_c+"', descripcion='"+descripcion+"' where id_categoria="+id_categoria+";";
        respuesta=0;
        
        try{
            st=conex.createStatement();
            respuesta=st.executeUpdate(sql);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return respuesta;
    }
    
    public int actualizarCompra(){
          return respuesta;
    }
    
    public int actualizarMateriales(String codigo_barras, int id_categoria,String nombre, float precio_venta, String marca, int stock){
        sql="update Materiales set id_categoria="+id_categoria+", nombre='"+nombre+"', precio_venta="+precio_venta+", marca='"+marca+"', stock="+stock+" where codigo_barras='"+codigo_barras+"';";
        respuesta=0;
        try{
            st=conex.createStatement();
            respuesta=st.executeUpdate(sql);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }       
          return respuesta;
    }
    
    public int actualizar_stock(int stock, String codigo_barras)
    {
        sql="update materiales set stock="+stock+" where codigo_barras='"+codigo_barras+"';";
        respuesta=0;
         try{
            st=conex.createStatement();
            respuesta=st.executeUpdate(sql);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }       
        return respuesta;
    }
    
    public void actualizarVenta(){
        
    }
    
   
    /*
    public void actualizarUsuarios(){
        
    }
    */
}
