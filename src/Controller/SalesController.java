/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author melodypc
 */
import Model.*;
import Model.ModelContsructor.*;
import View.*;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
public class SalesController {
    
    ProjectModel projectmodel = new ProjectModel();
    ClientModel clientmodel = new ClientModel();
    SupplierModel suppliermodel = new SupplierModel();
    ItemModel itemmodel = new ItemModel();
    PurchasedItemModel purchasedmodel = new PurchasedItemModel();
    ClientPOModel clientpomodel = new ClientPOModel();
    SupplierPOModel supplierpomodel = new SupplierPOModel();
    
    public static void main(String[] args){
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
    }
    
     public void addProject(){
        AddProject proj = new AddProject();
        proj.setVisible(true);
    }
     public void addProject(Map client, Map supplier, String project, String clientpo, String supplierpo, String items[][], Date cdate, Date sdate ){
        AddProject proj = new AddProject();
        String projname = proj.projectname.getText();
        
        
        boolean ccheck = clientmodel.Add(client);
        
        boolean scheck = suppliermodel.Add(supplier);
        if(ccheck == false || scheck == false){
           if(ccheck == false &&  scheck == true)
               JOptionPane.showMessageDialog(proj, "Invalid client information input! Project not added.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
           else if(scheck == false && ccheck == true )
               JOptionPane.showMessageDialog(proj, "Invalid supplier information input! Project not added", "Invalid Input", JOptionPane.ERROR_MESSAGE);
           else
               JOptionPane.showMessageDialog(proj, "Invalid client and supplier information input! Project not added", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else{
          try{
           boolean pcheck = projectmodel.Add(project,clientpo);
           if(!pcheck){
               statement = projectmodel.Read(project);
           }
           boolean cpocheck = clientpomodel.Add(clientpo,cdate.toString(),client.get("name").toString());
           boolean spocheck = supplierpomodel.Add(supplierpo,sdate.toString(),supplier.get("name").toString());
           boolean itemcheck = itemmodel.Add(items);
           boolean purchasecheck = purchasedmodel.Add(items,clientpo);
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(proj, "Invalid input(s) found!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
          }
        }
        
    }
}
