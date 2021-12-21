/*
 * Shipfitorder.java
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
import eve.interfaces.logicentity.IShipfitorder;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.interfaces.searchentity.IShipfitordersearch;
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
@WebServlet(name="Shipfitorder", urlPatterns={"/eve.Shipfitorder"})
public class Shipfitorder extends SecurityDataServlet {
   
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
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        blshipfitorder.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IShipfitorderPK shipfitorderPK;
                    IShipfitorder shipfitorder;
                    switch(this.operation) {
                        case IShipfitorderOperation.SELECT_ALL:
                            dataobject = blshipfitorder.getShipfitorders();
                            break;
                        case IShipfitorderOperation.SELECT_SHIPFITORDER:
                            shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
                            dataobject = blshipfitorder.getShipfitorder(shipfitorderPK);
                            break;
                        case IShipfitorderOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
                            dataobject = blshipfitorder.getShipfitorders4shipfit(shipfitPK);
                            break;
                        case IShipfitorderOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blshipfitorder.getShipfitorders4evetype(evetypePK);
                            break;
                        case IShipfitorderOperation.SELECT_Shipfitorderselected:
                            IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)parser.getJavaObject("shipfitorderselectedpk");
                            dataobject = blshipfitorder.getShipfitorderselected(shipfitorderselectedPK);
                            break;
                        case IShipfitorderOperation.SELECT_SEARCH:
                            IShipfitordersearch search = (IShipfitordersearch)parser.getJavaObject("search");
                            dataobject = blshipfitorder.search(search);
                            break;
                        case IShipfitorderOperation.SELECT_SEARCHCOUNT:
                            IShipfitordersearch shipfitordersearch = (IShipfitordersearch)parser.getJavaObject("search");
                            dataobject = blshipfitorder.searchcount(shipfitordersearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IShipfitorderOperation.INSERT_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)parser.getJavaObject("shipfitorder");
                            blshipfitorder.insertShipfitorder(shipfitorder);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IShipfitorderOperation.UPDATE_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)parser.getJavaObject("shipfitorder");
                            blshipfitorder.updateShipfitorder(shipfitorder);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IShipfitorderOperation.DELETE_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)parser.getJavaObject("shipfitorder");
                            blshipfitorder.deleteShipfitorder(shipfitorder);
                            break;
                        case IShipfitorderOperation.DELETE_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
                            blshipfitorder.delete4shipfit(shipfitPK);
                            break;
                        case IShipfitorderOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blshipfitorder.delete4evetype(evetypePK);
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
        return "shipfitorder";
    }

}

