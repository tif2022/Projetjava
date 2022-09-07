/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfime;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class ConexionBD {
     Connection conn=null;
     
       
    public static Connection Conexion(){
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fimeco?serverTimezone=UTC","root","Jesus est 1.");					
       return conn;
       
       }catch(Exception e) {
           System.out.println("--> SQLException : " + e) ;
           
       return null;
       }
    }    
}
