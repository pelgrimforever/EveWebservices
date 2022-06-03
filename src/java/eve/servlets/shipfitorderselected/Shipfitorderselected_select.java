/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.shipfitorderselected;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitorderselected;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitorderselected_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Shipfitorderselected_select", urlPatterns={"/eve.Shipfitorderselected_select"})
public class Shipfitorderselected_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitorderselectedOperation.SELECT_ALL:
                    dataobject = shipfitorderselectedusecases.get_all();
                    break;
                case IShipfitorderselectedOperation.SELECT_SHIPFITORDERSELECTED:
                    dataobject = get_shipfitorderselected_with_primarykey(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_Orders:
                    dataobject = get_shipfitorderselected_with_foreignkey_orders(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_Shipfitorder:
                    dataobject = get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_SEARCH:
                    dataobject = search_shipfitorderselected(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_shipfitorderselected_count(shipfitorderselectedusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_shipfitorderselected_with_primarykey(Shipfitorderselected_usecases shipfitorderselectedusecases) throws DBException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)parser.getJavaObject("shipfitorderselectedpk");
        return shipfitorderselectedusecases.get_shipfitorderselected_by_primarykey(shipfitorderselectedPK);
    }

    private Object get_shipfitorderselected_with_foreignkey_orders(Shipfitorderselected_usecases shipfitorderselectedusecases) throws CustomException {
        IOrdersPK ordersPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_orders(ordersPK);
    }
    
    private Object get_shipfitorderselected_with_foreignkey_shipfitorder(Shipfitorderselected_usecases shipfitorderselectedusecases) throws CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
        return shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderPK);
    }
    
    private Object search_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases) throws CustomException {
        IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)parser.getJavaObject("search");
        return shipfitorderselectedusecases.search_shipfitorderselected(search);
    }
    
    private Object search_shipfitorderselected_count(Shipfitorderselected_usecases shipfitorderselectedusecases) throws CustomException {
        IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)parser.getJavaObject("search");
        return shipfitorderselectedusecases.search_shipfitorderselected_count(shipfitorderselectedsearch);
    }

    @Override
    public String getServletInfo() {
        return "shipfitorderselected_select";
    }

}

