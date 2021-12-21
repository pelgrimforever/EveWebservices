/*
 * Shipfit.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 19.11.2021 16:16
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfit;
import eve.interfaces.servlet.IShipfitOperation;
import eve.interfaces.searchentity.IShipfitsearch;
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
@WebServlet(name="Shipfit", urlPatterns={"/eve.Shipfit"})
public class Shipfit extends SecurityDataServlet {
   
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
        BLshipfit blshipfit = new BLshipfit();
        blshipfit.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IShipfitPK shipfitPK;
                    IShipfit shipfit;
                    switch(this.operation) {
                        case IShipfitOperation.SELECT_ALL:
                            dataobject = blshipfit.getShipfits();
                            break;
                        case IShipfitOperation.SELECT_SHIPFIT:
                            shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
                            dataobject = blshipfit.getShipfit(shipfitPK);
                            break;
                        case IShipfitOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blshipfit.getShipfits4evetype(evetypePK);
                            break;
                        case IShipfitOperation.SELECT_Shipfitmodule:
                            IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)parser.getJavaObject("shipfitmodulepk");
                            dataobject = blshipfit.getShipfitmodule(shipfitmodulePK);
                            break;
                        case IShipfitOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
                            dataobject = blshipfit.getShipfitorder(shipfitorderPK);
                            break;
                        case IShipfitOperation.SELECT_SEARCH:
                            IShipfitsearch search = (IShipfitsearch)parser.getJavaObject("search");
                            dataobject = blshipfit.search(search);
                            break;
                        case IShipfitOperation.SELECT_SEARCHCOUNT:
                            IShipfitsearch shipfitsearch = (IShipfitsearch)parser.getJavaObject("search");
                            dataobject = blshipfit.searchcount(shipfitsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IShipfitOperation.INSERT_SHIPFIT:
                            shipfit = (IShipfit)parser.getJavaObject("shipfit");
                            blshipfit.insertShipfit(shipfit);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IShipfitOperation.UPDATE_SHIPFIT:
                            shipfit = (IShipfit)parser.getJavaObject("shipfit");
                            blshipfit.updateShipfit(shipfit);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IShipfitOperation.DELETE_SHIPFIT:
                            shipfit = (IShipfit)parser.getJavaObject("shipfit");
                            blshipfit.deleteShipfit(shipfit);
                            break;
                        case IShipfitOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blshipfit.delete4evetype(evetypePK);
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
        return "shipfit";
    }

}

