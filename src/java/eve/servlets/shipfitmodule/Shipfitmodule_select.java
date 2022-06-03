/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.shipfitmodule;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitmodule_usecases;
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
@WebServlet(name="Shipfitmodule_select", urlPatterns={"/eve.Shipfitmodule_select"})
public class Shipfitmodule_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitmoduleOperation.SELECT_ALL:
                    dataobject = shipfitmoduleusecases.get_all();
                    break;
                case IShipfitmoduleOperation.SELECT_SHIPFITMODULE:
                    dataobject = get_shipfitmodule_with_primarykey(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_Evetype:
                    dataobject = get_shipfitmodule_with_foreignkey_evetype(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_Shipfit:
                    dataobject = get_shipfitmodule_with_foreignkey_shipfit(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_SEARCH:
                    dataobject = search_shipfitmodule(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_shipfitmodule_count(shipfitmoduleusecases);
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

    private Object get_shipfitmodule_with_primarykey(Shipfitmodule_usecases shipfitmoduleusecases) throws DBException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)parser.getJavaObject("shipfitmodulepk");
        return shipfitmoduleusecases.get_shipfitmodule_by_primarykey(shipfitmodulePK);
    }

    private Object get_shipfitmodule_with_foreignkey_evetype(Shipfitmodule_usecases shipfitmoduleusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_shipfitmodule_with_foreignkey_shipfit(Shipfitmodule_usecases shipfitmoduleusecases) throws CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)parser.getJavaObject("shipfitpk");
        return shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_shipfit(shipfitPK);
    }
    
    private Object search_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases) throws CustomException {
        IShipfitmodulesearch search = (IShipfitmodulesearch)parser.getJavaObject("search");
        return shipfitmoduleusecases.search_shipfitmodule(search);
    }
    
    private Object search_shipfitmodule_count(Shipfitmodule_usecases shipfitmoduleusecases) throws CustomException {
        IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)parser.getJavaObject("search");
        return shipfitmoduleusecases.search_shipfitmodule_count(shipfitmodulesearch);
    }

    @Override
    public String getServletInfo() {
        return "shipfitmodule_select";
    }

}

