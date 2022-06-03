/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.shipfitorder;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitorder;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitorder_usecases;
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
@WebServlet(name="Shipfitorder_select", urlPatterns={"/eve.Shipfitorder_select"})
public class Shipfitorder_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitorderOperation.SELECT_ALL:
                    dataobject = shipfitorderusecases.get_all();
                    break;
                case IShipfitorderOperation.SELECT_SHIPFITORDER:
                    dataobject = get_shipfitorder_with_primarykey(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_Shipfit:
                    dataobject = get_shipfitorder_with_foreignkey_shipfit(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_Evetype:
                    dataobject = get_shipfitorder_with_foreignkey_evetype(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_Shipfitorderselected:
                    dataobject = get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_SEARCH:
                    dataobject = search_shipfitorder(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_shipfitorder_count(shipfitorderusecases);
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

    private Object get_shipfitorder_with_primarykey(Shipfitorder_usecases shipfitorderusecases) throws DBException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
        return shipfitorderusecases.get_shipfitorder_by_primarykey(shipfitorderPK);
    }

    private Object get_shipfitorder_with_foreignkey_shipfit(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
        return shipfitorderusecases.get_shipfitorder_with_foreignkey_shipfit(shipfitPK);
    }
    
    private Object get_shipfitorder_with_foreignkey_evetype(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return shipfitorderusecases.get_shipfitorder_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_shipfitorder_with_externalforeignkey_shipfitorderselected(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)parser.getJavaObject("shipfitorderselectedpk");
        return shipfitorderusecases.get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderselectedPK);
    }
    
    private Object search_shipfitorder(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IShipfitordersearch search = (IShipfitordersearch)parser.getJavaObject("search");
        return shipfitorderusecases.search_shipfitorder(search);
    }
    
    private Object search_shipfitorder_count(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IShipfitordersearch shipfitordersearch = (IShipfitordersearch)parser.getJavaObject("search");
        return shipfitorderusecases.search_shipfitorder_count(shipfitordersearch);
    }

    @Override
    public String getServletInfo() {
        return "shipfitorder_select";
    }

}

