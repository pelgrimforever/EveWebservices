/*
 * Shipfitorderselected.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.11.2021 17:22
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitorderselected;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
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
@WebServlet(name="Shipfitorderselected", urlPatterns={"/eve.Shipfitorderselected"})
public class Shipfitorderselected extends SecurityDataServlet {
   
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
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        blshipfitorderselected.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IShipfitorderselectedPK shipfitorderselectedPK;
                    IShipfitorderselected shipfitorderselected;
                    switch(this.operation) {
                        case IShipfitorderselectedOperation.SELECT_ALL:
                            dataobject = blshipfitorderselected.getShipfitorderselecteds();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SHIPFITORDERSELECTED:
                            shipfitorderselectedPK = (IShipfitorderselectedPK)parser.getJavaObject("shipfitorderselectedpk");
                            dataobject = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
                            break;
                        case IShipfitorderselectedOperation.SELECT_Orders:
                            IOrdersPK ordersPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK);
                            break;
                        case IShipfitorderselectedOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
                            dataobject = blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK);
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCH:
                            IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)parser.getJavaObject("search");
                            dataobject = blshipfitorderselected.search(search);
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCHCOUNT:
                            IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)parser.getJavaObject("search");
                            dataobject = blshipfitorderselected.searchcount(shipfitorderselectedsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IShipfitorderselectedOperation.INSERT_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)parser.getJavaObject("shipfitorderselected");
                            blshipfitorderselected.insertShipfitorderselected(shipfitorderselected);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IShipfitorderselectedOperation.UPDATE_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)parser.getJavaObject("shipfitorderselected");
                            blshipfitorderselected.updateShipfitorderselected(shipfitorderselected);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IShipfitorderselectedOperation.DELETE_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)parser.getJavaObject("shipfitorderselected");
                            blshipfitorderselected.deleteShipfitorderselected(shipfitorderselected);
                            break;
                        case IShipfitorderselectedOperation.DELETE_Orders:
                            IOrdersPK ordersPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            blshipfitorderselected.delete4orders(ordersPK);
                            break;
                        case IShipfitorderselectedOperation.DELETE_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
                            blshipfitorderselected.delete4shipfitorder(shipfitorderPK);
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
        return "shipfitorderselected";
    }

}

