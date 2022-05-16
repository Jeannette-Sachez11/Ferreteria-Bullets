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
public class Eliminar {
    
    Connection conex;
    Conexion c = new Conexion();
    Statement stElim;
    String sqlElim;
    boolean respElim;
    
    public Eliminar(){
        conex = c.ConectarBD();
    }
    
    public boolean eliminarProveedor(String nombre){
      
        //se prepara la eliminacion del dato de proveedor
        sqlElim="delete from Proveedor where nombre='"+nombre+"';";
        respElim=true;// nos devuelven el valor booleano despues de la insercion
        try{
            stElim=conex.createStatement();
            respElim=stElim.execute(sqlElim);
            System.out.println(respElim);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                stElim.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
       
        return !respElim;//retorno de respuesta
        
    }
    
   public boolean eliminarCompra(int id_compra){
        
        sqlElim ="delete from CompraM where id_compra ="+id_compra+" ";
        respElim = true;
        
        try{
            stElim=conex.createStatement();
            respElim=stElim.execute(sqlElim);
            System.out.println(respElim);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                stElim.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        
         return !respElim;//retorno de respuesta
    }
    
    public boolean eliminarCategoria(String nombre_c){
        sqlElim="delete from categoria where nombre_c='"+nombre_c+"';";
        respElim=true;// nos devuelven el valor booleano despues de la insercion
        try{
            stElim=conex.createStatement();
            respElim=stElim.execute(sqlElim);
            System.out.println(respElim);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                stElim.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
      return !respElim;//retorno de respuesta   
    }
    
    public boolean eliminarMateriales(String codigo_barras){
        sqlElim=" delete from materiales where codigo_barras='"+codigo_barras+"';";
        respElim=true;// nos devuelven el valor booleano despues de la insercion
        try{
            stElim=conex.createStatement();
            respElim=stElim.execute(sqlElim);
            System.out.println(respElim);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                stElim.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
       
        return !respElim;//retorno de respuesta   
    }
    
   public boolean eliminarVenta(int id_venta){
        
        sqlElim = " delete from Venta where id_venta = "+id_venta+" ";
        respElim = true;
        
        try{
            stElim=conex.createStatement();
            respElim=stElim.execute(sqlElim);
            System.out.println(respElim);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                stElim.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        
        return respElim;
    }
    
   
}
