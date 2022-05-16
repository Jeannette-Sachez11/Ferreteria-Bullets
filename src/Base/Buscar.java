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
 * @author Noe Guillen Gerardo
 * @author Jeannette Sanchez Hernandez
 *
 * 
 */
public class Buscar {
    
    Connection conex;
    Conexion c = new Conexion();
    Statement st;
    ResultSet rs=null;
    PreparedStatement ps=null;
    String sql;//variable para recibir las sentencias de insercion
    int respu;
    public Buscar(){
        conex = c.ConectarBD();
    }
     public String[] buscarCod(String nombreUsu, String contraUsu){        
        String sql="select * from usuarios where nombreUsu='"+nombreUsu+"' and contraUsu='"+contraUsu+"';";
        String []x=new String[1];
        try{
           st=conex.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
               x[0]=rs.getString("nombreUsu");
               x[1]=rs.getString("contraUsu");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
     public String[] buscarProveedor(String nombre){
 
        String sql="select * from Proveedor where nombre='"+nombre+"';";
        String []y=new String[3];
        try{
           st=conex.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
               y[0] = rs.getString("id_proveedor");
               y[1] = rs.getString("telefono");
               y[2] = rs.getString("rfc");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return y;
        
    }
    
    public void buscarCompra(){
        
    }
    
    public String[] buscarCategoria(String nombre_c){
        
        String sql="select * from Categoria where nombre_c ='"+nombre_c+"';";
        String []y=new String[2];
        try{
           st=conex.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
               y[0] = rs.getString("descripcion");
               y[1] = rs.getString("id_categoria");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return y;
        
    }
     
    public String[] buscarMateriales(String codigo_barras)
    {   
        String sql="select * from  Materiales where codigo_barras = '"+codigo_barras+"';";
        String []y=new String[5];
        try{
           st=conex.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
               y[0] = rs.getString("id_categoria");
               y[1] = rs.getString("nombre");
               y[2] = rs.getString("precio_venta");
               y[3] = rs.getString("marca");
               y[4]=rs.getString("Stock");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return y;
        
    }
    
    public String buscarIdc(){//busca el id compra mas alto
        String idc="";
        sql="select max(id_compra) from compraM;";
        try{
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                idc=rs.getString(1);
            }
      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        
        return idc;
    }
    
    public String BuacarIDV()
    {
        String idv="";
        sql="select max(id_venta) from Venta;";
        try{
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                idv=rs.getString(1);
            }
      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        
        
        return idv;
    }
    
    public String BuscarStock(String codigo_barras)
    {
       String stock="";
       sql="select stock from materiales where codigo_barras='"+codigo_barras+"';";
       try{
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                stock=rs.getString(1);
            }
      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
       return stock; 
    }
    
    public String BuscarNombre(String codigo_barras){
        String Nombre="";
        sql="select nombre from materiales where codigo_barras='"+codigo_barras+"';";
        try{
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                Nombre=rs.getString(1);
            }
      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        
        return Nombre;
    }
    
    public String BuscarPrecio(String codigo_barras)
    {
        String precio="";
        sql="select precio_venta from materiales where codigo_barras='"+codigo_barras+"';";
         try{
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                precio=rs.getString(1);
            }
      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return precio;
    }
    
    public void buscarVenta(){
        
    }
    
    public void buscarDetaVenta(){
        
    }
   
   //--------------------------------------------------------------Realizar validaciones------------------------------------
    public int ValidarCategoria(String Nombre_c)
    {//metodo que valida el dato antes de registrase en la base de datos
        respu=0;//bandera
        try
        {
            sql="select nombre_c from categoria where nombre_c='"+Nombre_c+"';";
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) 
            {
                System.out.println("El dato existe en la base de datos!!");
                respu=0;//si el dato fue encontado se da la bandera de 0
            }else
            {
                System.out.println("El dato no ha sido registrado");
                respu=1;//el dato NO fue encontrado asi que manda la bandera de 1
            }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return respu;
    }//metodo de validar categoria
    
    public int ValidarProveedor(String Nombre){
        respu=0;
        try{
            sql="select nombre from Proveedor where nombre='"+Nombre+"';";
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Dato existente");
                respu=0;//si el dato fue encontado se da la bandera de 0
            }else{
                System.out.println("El dato no existe!");
                respu=1;//el dato NO fue encontrado asi que manda la bandera de 1
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return respu;
    }
    
    public int ValidarMaterial(String codigo_barras)
    {
        respu=0;
        try{
            sql="select codigo_barras from materiales where codigo_barras='"+codigo_barras+"';";
            st=conex.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Dato existente");
                respu=0;//si el dato fue encontado se da la bandera de 0
            }else{
                System.out.println("El dato no existe!");
                respu=1;//el dato NO fue encontrado asi que manda la bandera de 1
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        
        return respu;
    }
    //---------------------------------------------Buscar el maximo ide de compra y venta--------------------------------------------------
    public void maxCompra(){
    }
    public void maxVenta(){
    }
    
}//fin de la clase buscar
