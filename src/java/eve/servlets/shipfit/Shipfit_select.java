/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.shipfit;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfit;
import eve.interfaces.servlet.IShipfitOperation;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfit_usecases;
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
@WebServlet(name="Shipfit_select", urlPatterns={"/eve.Shipfit_select"})
public class Shipfit_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfit_usecases shipfitusecases = new Shipfit_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitOperation.SELECT_ALL:
                    dataobject = shipfitusecases.get_all();
                    break;
                case IShipfitOperation.SELECT_SHIPFIT:
                    dataobject = get_shipfit_with_primarykey(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_Evetype:
                    dataobject = get_shipfit_with_foreignkey_evetype(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_Shipfitmodule:
                    dataobject = get_shipfit_with_externalforeignkey_shipfitmodule(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_Shipfitorder:
                    dataobject = get_shipfit_with_externalforeignkey_shipfitorder(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_SEARCH:
                    dataobject = search_shipfit(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_shipfit_count(shipfitusecases);
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

    private Object get_shipfit_with_primarykey(Shipfit_usecases shipfitusecases) throws DBException {
        IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
        return shipfitusecases.get_shipfit_by_primarykey(shipfitPK);
    }

    private Object get_shipfit_with_foreignkey_evetype(Shipfit_usecases shipfitusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return shipfitusecases.get_shipfit_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_shipfit_with_externalforeignkey_shipfitmodule(Shipfit_usecases shipfitusecases) throws CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)parser.getJavaObject("shipfitmodulepk");
        return shipfitusecases.get_shipfit_with_externalforeignkey_shipfitmodule(shipfitmodulePK);
    }
    
    private Object get_shipfit_with_externalforeignkey_shipfitorder(Shipfit_usecases shipfitusecases) throws CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
        return shipfitusecases.get_shipfit_with_externalforeignkey_shipfitorder(shipfitorderPK);
    }
    
    private Object search_shipfit(Shipfit_usecases shipfitusecases) throws CustomException {
        IShipfitsearch search = (IShipfitsearch)parser.getJavaObject("search");
        return shipfitusecases.search_shipfit(search);
    }
    
    private Object search_shipfit_count(Shipfit_usecases shipfitusecases) throws CustomException {
        IShipfitsearch shipfitsearch = (IShipfitsearch)parser.getJavaObject("search");
        return shipfitusecases.search_shipfit_count(shipfitsearch);
    }

    @Override
    public String getServletInfo() {
        return "shipfit_select";
    }

}

