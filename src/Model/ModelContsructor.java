/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author melodypc
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

public class ModelContsructor {

    /**
     */
    public static Connection con;
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{  
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
        ClientModel sample = new ClientModel();
        String a = sample.Read();
        //here sonoo is database name, root is username and password  
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println(e);}
    }
    
   
    
    public static class ClientModel{
        public String Read(){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from client");  
                while(rs.next())  
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.getString(1);
            }
            catch(SQLException e){ 
                System.out.println(e);
                return e.toString();
            }
        }
         public String Read(String argument){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from client WHERE ".concat(argument));  
                while(rs.next())  
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.getString(1);
            }
            catch(SQLException e){ System.out.println(e);
            return e.toString();
            }
            
        }
       public Boolean Add(Map client){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO client (client_name, address, contact_no, contact_person) VALUES (?,?,?,?)"; 
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
                
                System.out.println(client);
                pstmt.setString(1,client.get("name").toString()); 
                pstmt.setString(2,client.get("address").toString()); 
                pstmt.setString(3,client.get("number").toString()); 
                pstmt.setString(4,client.get("contact").toString()); 
                pstmt.executeUpdate(); 
                
                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
                return false;
                
            }
       }
       public String Update(String client, String add,String contactnum, String contact){
           try{
               Statement stmt=con.createStatement();  
               String query = " update users set (client_name = "+client+", contact_no = "+contactnum+",contact_person = "+contact+"  "
                       + "where client_name = "+client;
               
                return "success!";
            }
            catch(SQLException e){ System.out.println(e);
            return e.toString();
            }
       }
    }
    
    public static class SupplierModel{
        public String Read(){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from supplier");  
                while(rs.next())  
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.toString();
            }
            catch(SQLException e){ 
                System.out.println(e);
                return e.toString();
            }
        }
         public String Read(String argument){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from supplier WHERE ".concat(argument));  
                while(rs.next())  
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.getString(1);
            }
            catch(SQLException e){ System.out.println(e);
            return e.toString();
            }
            
        }
         
        public Boolean Add(Map supplier){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO supplier (supplier_name, address, contact_no, contact_person) VALUES (?,?,?,?)"; 
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
                
                System.out.println(supplier);
                pstmt.setString(1,supplier.get("name").toString()); 
                pstmt.setString(2, supplier.get("address").toString()); 
                pstmt.setString(3,supplier.get("number").toString()); 
                pstmt.setString(4,supplier.get("contact").toString()); 
                pstmt.executeUpdate(); 

                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
                return false;
            }
       }

    }
    
    public static class ProjectModel{
        
        public String Read(){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from project");  
                while(rs.next())  
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.getString(1);
            }
            catch(SQLException e){ 
                System.out.println(e);
                return e.toString();
            }
        }
        
        public String Read(String read, String value){
            try{
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from project");  
                while(rs.next())  
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                return rs.getString(1);
            }
            catch(SQLException e){ 
                System.out.println(e);
                return e.toString();
            }
        }
        
            
            
        public Boolean Add(String project, String clientPO){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO project (project_name, client_PO) VALUES (?,?)"; 
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
                
                System.out.println(project);
                pstmt.setString(1,project);
                pstmt.setString(2,clientPO); 
                pstmt.executeUpdate(); 

                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
                return false;
            }
       }
    }
    
    public static class ClientPOModel{
        public Boolean Add(String clientPO, String clientdate, String clientname ){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO clientpo (client_PO,date,client_name) VALUES (?,?,?)"; 
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
//                System.out.println(project);
                pstmt.setString(1,clientPO);
                pstmt.setString(2,clientdate); 
                pstmt.setString(3,clientname); 
                pstmt.executeUpdate(); 

                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
                return false;
            }
       }
    }
    
    
    public static class SupplierPOModel{
        public Boolean Add(String supplierPO,String supplierdate, String suppliername ){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO supplierpo (supplier_PO,date,supplier_name) VALUES (?,?,?)"; 
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
//                System.out.println(project);
                pstmt.setString(1,supplierPO);
                pstmt.setString(2,supplierdate); 
                pstmt.setString(3,suppliername); 
                pstmt.executeUpdate(); 

                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
                return false;
            }
       }
    }
    
    public static class ItemModel{
        public Boolean Add(String items[][]){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO item (brand, description, inclusions) VALUES (?,?,?)"; 
               
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
                int x = 0;
                int count = items.length;
               
                while( x < count){
                     pstmt.setString(1,items[x][0]);
                     pstmt.setString(2,items[x][1]);
                     pstmt.setString(3,items[x][2]);
                     pstmt.executeUpdate();
                    x++;
                }
                
                
                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e+"testing1");
                return false;
            }
       }
    }
    
    
    public static class PurchasedItemModel{
        public Boolean Add(String items[][], String clientPO){
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mci","root","");
                String Sql="INSERT INTO delivery (DR_no, serial_no, date_shipped, client_PO) VALUES (?,?,?,?)"; 
               
                PreparedStatement pstmt=con.prepareStatement(Sql); 
                //pstmt.setString(1,txtTrial.getText()); 
                int x = 0;
                int count = items.length;
               
                while( x < count){
                     pstmt.setString(1,items[x][3]);
                     pstmt.setString(2,items[x][4]);
                     pstmt.setString(3,items[x][5]);
                     pstmt.setString(4,clientPO); 
                     pstmt.executeUpdate();
                    x++;
                }
                
                
                return true;
            }
            catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e+"testing");
                return false;
            }
       }
    }
    
}

