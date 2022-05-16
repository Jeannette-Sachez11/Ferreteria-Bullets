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
public class Insertar {

    Connection conex;
    Conexion c = new Conexion();
    Statement st;
    String sql;//variable para recibir las sentencias de insercion
    boolean respuesta;
    
    public Insertar(){
        conex = c.ConectarBD();
    }
    
    public boolean insertarProveedor(String Nombre,String Telefono,String rfc){//metodo para insertar un proveedor
        //se prepara la insercion del dato de proveedor
        sql="Insert into proveedor(nombre,telefono,rfc) values ('"+Nombre+"','"+Telefono+"','"+rfc+"')";
        respuesta=true;// nos devuelven el valor booleano despues de la insercion
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
       
        return !respuesta;//retorno de respuesta
        
    }
       
    public boolean insertarCategoria(String Nombre_c,String Descripcion){//metodo para insertar una categoria
        sql="Insert into Categoria (nombre_c,descripcion) values ('"+Nombre_c+"','"+Descripcion+"')";
        respuesta=true;// nos devuelven el valor booleano despues de la insercion
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        
        return !respuesta;//retorno de respuesta
    }
 
   public boolean insertarMateriales(String codigo_barras,int id_categoria, String nombre, float precio_venta,String marca, int stock){
        sql="insert into materiales values('"+codigo_barras+"',"+id_categoria+",'"+nombre+"',"+precio_venta+",'"+marca+"',"+stock+");";
        respuesta = true;
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        return !respuesta;
    }
 
    public boolean insertarCompra(int id_proveedor, float Monto_ct, String fecha){//metodo para insertar una compra
        sql="insert into compraM (id_proveedor, montoCTotal, fechaCompra) values("+id_proveedor+", "+Monto_ct+", '"+fecha+"')";
        respuesta = true;
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        
        return !respuesta;//retorno de respuesta
    }
    public boolean insertarDetaCompra(int id_compra, int cns, String Codigo_barras, String descripcion, int cant, float preciodc, float montopc){ //metodo para insertar
        sql="insert into Detalle_compra values("+id_compra+", "+cns+",'"+Codigo_barras+"', '"+descripcion+"',"+cant+","+preciodc+", "+montopc+");";
        respuesta=true;
         try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
        return !respuesta;//retorno de respuesta
    }

    public boolean insertarVenta(float monto_final, String Fecha){//metodo para insertar una venta
        sql="insert into venta (monto_final, fecha_venta) values("+monto_final+",'"+Fecha+"');";
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }
         return !respuesta;//retorno de respuesta
    }
    
    public boolean insertarDetalle_Venta(int cns, int id_venta, String codigo_barras, int cantidad,float precio_vt, float monto_pv){//metodo para insertar 
        sql="insert into Detalle_Venta values("+cns+","+id_venta+",'"+codigo_barras+"',"+cantidad+","+precio_vt+","+monto_pv+");";
        try{
            st=conex.createStatement();
            respuesta=st.execute(sql);
            System.out.println(respuesta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        }finally{
            try{
                st.close();//cierra la conexion
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() );
                System.out.println(ex.getMessage());
            }
        }            
         return !respuesta;//retorno de respuesta
    }
    
    /*
    De esta tabla no estoy seguro si se debe de hacer crud, pero lo dejo, por si las moscas
        public void insertarUsuarios(){
        
        }
    */
    
}
