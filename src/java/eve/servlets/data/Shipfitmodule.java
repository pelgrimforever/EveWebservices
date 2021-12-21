/*
 * Shipfitmodule.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.11.2021 15:31
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Shipfitmodule", urlPatterns={"/eve.Shipfitmodule"})
public class Shipfitmodule extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        blshipfitmodule.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IShipfitmodulePK shipfitmodulePK;
                    IShipfitmodule shipfitmodule;
                    switch(this.operation) {
                        case IShipfitmoduleOperation.SELECT_ALL:
                            dataobject = blshipfitmodule.getShipfitmodules();
                            break;
                        case IShipfitmoduleOperation.SELECT_SHIPFITMODULE:
                            shipfitmodulePK = (IShipfitmodulePK)parser.getJavaObject("shipfitmodulepk");
                            dataobject = blshipfitmodule.getShipfitmodule(shipfitmodulePK);
                            break;
                        case IShipfitmoduleOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blshipfitmodule.getShipfitmodules4evetype(evetypePK);
                            break;
                        case IShipfitmoduleOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
                            dataobject = blshipfitmodule.getShipfitmodules4shipfit(shipfitPK);
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCH:
                            IShipfitmodulesearch search = (IShipfitmodulesearch)parser.getJavaObject("search");
                            dataobject = blshipfitmodule.search(search);
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCHCOUNT:
                            IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)parser.getJavaObject("search");
                            dataobject = blshipfitmodule.searchcount(shipfitmodulesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IShipfitmoduleOperation.INSERT_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)parser.getJavaObject("shipfitmodule");
                            blshipfitmodule.insertShipfitmodule(shipfitmodule);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IShipfitmoduleOperation.UPDATE_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)parser.getJavaObject("shipfitmodule");
                            blshipfitmodule.updateShipfitmodule(shipfitmodule);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IShipfitmoduleOperation.DELETE_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)parser.getJavaObject("shipfitmodule");
                            blshipfitmodule.deleteShipfitmodule(shipfitmodule);
                            break;
                        case IShipfitmoduleOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blshipfitmodule.delete4evetype(evetypePK);
                            break;
                        case IShipfitmoduleOperation.DELETE_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
                            blshipfitmodule.delete4shipfit(shipfitPK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "shipfitmodule";
    }

}

